package com.main.cli.actions;

import com.main.cli.interfaces.AddExecutable;
import com.main.cli.utils.FileHandler;
import java.io.FileWriter;

public class Add extends FileHandler implements AddExecutable {

	public Add() {
		super();
	}

	@Override
	public void execute(String task) {
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
}
