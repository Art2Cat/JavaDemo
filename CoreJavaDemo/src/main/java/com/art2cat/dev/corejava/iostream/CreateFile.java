package com.art2cat.dev.corejava.iostream;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.*;


public class CreateFile {
	public static void main(String[] args) throws URISyntaxException {
		Path dir = Paths.get( "test.txt");
		try  {
			Files.createFile(dir);
		} catch (FileAlreadyExistsException x) {
			System.err.format("file named %s" +
					" already exists%n", dir);
		} catch (IOException x) {
			// Some other sort of failure, such as permissions.
			System.err.format("createFile error: %s%n", x);
		}

	}
}
