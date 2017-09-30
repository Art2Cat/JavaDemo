import org.junit.Assert;
import org.junit.Test;

import java.net.URL;
import java.nio.file.Paths;

public class PathsTest {

	@Test
	public void test() {
		String path = Paths.get("text.txt").toAbsolutePath().toString();


		System.out.println(path);
		path = Paths.get("").toAbsolutePath().toString();

		System.out.println(path);
	}

	@Test
	public void test1() {
		URL url = this.getClass().getClassLoader().getResource("text.txt");
		if (url == null) {
			Assert.fail();
		}
		String path = url.getPath();
		System.out.println(path);

		Long number = 18658710313L;

		System.out.println(String.valueOf(number).length());
	}
}
