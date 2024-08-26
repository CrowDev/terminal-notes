package com.main.cli.actions;
import com.main.cli.interfaces.UpdateExecutable;
import com.main.cli.utils.FileHandler;
import java.util.Scanner;
import java.io.FileWriter;

public class Update extends FileHandler implements UpdateExecutable {
	public Update() {
		super();
	}

	public void execute(String id, String task) {
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
}