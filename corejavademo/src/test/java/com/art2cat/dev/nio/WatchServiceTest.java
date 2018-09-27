package com.art2cat.dev.nio;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

public class WatchServiceTest {

    @Test
    public void test() throws IOException, InterruptedException, ExecutionException {
        boolean done = false;
        Path path = Paths
                .get("src", "test", "resources");
        WatchService watchService = FileSystems.getDefault().newWatchService();
        WatchEvent.Kind<?>[] watchKinds = {ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE};
        path.register(watchService, watchKinds);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<File> future = executorService.submit(new TmpFileCreator(path.toString()));
        File file = null;
        while (!done) {
            WatchKey key = watchService.take();
            for (WatchEvent<?> e : key.pollEvents()) {
                System.out.println("Saw event " + e.kind() + " on " + e.context());
                if (e.context().toString().equals("MyFileSema.For")) {
                    System.out.println("Semaphore found, shutting down watcher");
                    done = true;
                }
            }
            if (!key.reset()) {
                System.err.println("Key failed to reset!");
            }
        }
        if (future.isDone()) {
            file = future.get();
            System.out.println(file.getCanonicalPath());
        }
        if (Objects.nonNull(file)) {
            if (file.delete()) {
                System.out.println("tmp file deleted");
            }
        }
        executorService.shutdown();
        System.out.println("exit!");
    }
}
