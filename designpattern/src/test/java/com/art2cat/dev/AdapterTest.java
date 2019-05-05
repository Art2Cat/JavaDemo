package com.art2cat.dev;

import com.art2cat.dev.adapter.Badge;
import com.art2cat.dev.adapter.Banner;
import com.art2cat.dev.adapter.INotification;
import com.art2cat.dev.adapter.IPrint;
import com.art2cat.dev.adapter.PrintAdapter;
import com.art2cat.dev.adapter.PrintBanner;
import com.art2cat.dev.adapter.practice.FileProperties;
import com.art2cat.dev.adapter.practice.IFileIO;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 5/15/2018
 */
public class AdapterTest {

    @Test
    public void test() {
        IPrint printBanner = new PrintBanner("Hello");
        printBanner.printWeak();
        printBanner.printStrong();

        INotification banner = new Banner("Hello");
        INotification badge = new Badge("World");
        IPrint bannerAdapter = new PrintAdapter(banner);
        IPrint badgeAdapter = new PrintAdapter(badge);
        bannerAdapter.printStrong();
        badgeAdapter.printWeak();
        bannerAdapter.printStrong();
        badgeAdapter.printWeak();
    }

    @Test
    public void testFileProperties() {
        Path filePath = Paths.get("src", "test", "resources", "properties.txt");
        IFileIO f = new FileProperties();
        try {
            f.readFromFile(filePath);
            f.setValue("year", "2018");
            f.setValue("month", "Dec");
            f.setValue("day", "3");
            f.writeToFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
