import org.junit.Test;

import java.nio.file.Paths;

public class PathsTest {

	@Test
	public void test() {
		String path = Paths.get("text.txt").toAbsolutePath().toString();

		System.out.println(path);
		path = Paths.get("").toAbsolutePath().toString();

		System.out.println(path);
	}
}
