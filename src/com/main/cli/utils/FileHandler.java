package com.main.cli.utils;

import java.io.File;
import java.util.Scanner;

public class FileHandler {
	private final String dir = "/var/lib/note";
	private final String fileName = "tasks.txt";
	protected File file;
	protected int currentId = 0;

	public FileHandler() {
		this.checkFile();
		this.getLastId();
	}

	private void checkFile() {
		String tmpPath = (true) ? "db" : this.dir;
		System.out.println(tmpPath);
		try {
			File path = new File(tmpPath);
			if (!path.exists()) {
				path.mkdir();
			}
			this.file = new File(path, this.fileName);
			System.out.println(this.file);
			if (!this.file.exists()) {
				this.file.createNewFile();
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private void getLastId() {
		try {
			Scanner reader = new Scanner(this.file);
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				String id = line.split(" ")[0];
				this.currentId = Integer.parseInt(id);
				this.currentId++;
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
