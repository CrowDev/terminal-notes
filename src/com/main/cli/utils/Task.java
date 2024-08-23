package com.main.cli.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Task {
		private File file;
		private int currentId = 0;
		private final String dir = "/var/lib/note";
		private final String fileName = "tasks.txt";

		Task() {
			this.checkFile();
			this.setCurrentId();
		}

		public void add(String task) {
			try {
				FileWriter writer = new FileWriter(this.file, true);
				writer.write(this.currentId + " " + task + "\n");
				writer.close();
				this.currentId++;
			} catch (Exception e) {
				System.out.println("Here");
				System.out.println("Error: " + e.getMessage());
			}
		}

		public void update(String id, String task) {
			try {
				Scanner Reader = new Scanner(this.file);
				String output = "";
				while (Reader.hasNextLine()) {
					String lineString = Reader.nextLine();
					String idLine = lineString.split(" ")[0];
					output += (idLine.equals(id))
						? (id + " " + task + "\n")
						: (lineString + "\n");
				}
				FileWriter writer = new FileWriter(this.file);
				writer.write(output);
				writer.close();
				Reader.close();
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}

		public void listTasks() {
			try {
				Scanner Reader = new Scanner(this.file);
				while (Reader.hasNextLine()) {
					System.out.println(Reader.nextLine());
				}
				Reader.close();
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}

		private void checkFile() {
			String tmpPath = (false) ? "db" : this.dir;
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

		private void setCurrentId() {
			try {
				Scanner Reader = new Scanner(this.file);
				while (Reader.hasNextLine()) {
					String lineString = Reader.nextLine();
					int id = Integer.parseInt(lineString.split(" ")[0]);
					this.currentId = id + 1;
				}
				Reader.close();
			} catch (Exception e) {
				this.currentId = 0;
				System.out.println("Error: " + e.getMessage());
			}
		}
}
