package com.main.cli.actions;

import com.main.cli.interfaces.EmptyExecutable;
import com.main.cli.utils.FileHandler;
import java.util.Scanner;

public class List extends FileHandler implements EmptyExecutable {
	public List() {
		super();
	}

	@Override
	public void execute() {
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

}
