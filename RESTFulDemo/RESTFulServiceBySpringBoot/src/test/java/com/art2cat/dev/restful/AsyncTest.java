package com.art2cat.dev.restful;

import com.art2cat.dev.restful.model.TestObject;
import com.art2cat.dev.restful.utils.AESUtils;
import com.art2cat.dev.restful.utils.MD5Utils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AsyncTest {
	TestObject testObject;


	@Before
	public void init() {
		testObject = new TestObject();
		testObject.setFirstName("testsss");
		testObject.setUsername("tssfdestsss");
		testObject.setPassword("testfdfdsss");
		testObject.setLastName("testssadfass");

	}

	@Test
	public void test() {
		final String key = AESUtils.generateKey();
		final Executor executor = Executors.newFixedThreadPool(2, Thread::new);

		CompletableFuture.supplyAsync(() -> testObject.get(), executor)
				.thenApplyAsync(s1 -> {
					System.out.println(Thread.currentThread().getName() + s1.size());
					List<Optional<String>> optionals = new ArrayList<>();
					s1.forEach(s ->
							optionals.add(Optional.ofNullable(
									MD5Utils.getMD5(
											s.orElse("null")))));
					System.out.println(optionals.size());
					return optionals;

				}).thenAccept(optionals ->
				optionals.forEach(s -> s.ifPresent(s1 ->
						System.out.println(Thread.currentThread().getName()
								+ s1))));
	}
}
