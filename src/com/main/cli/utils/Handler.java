package com.main.cli.utils;

import java.util.HashMap;
import java.util.Map;

public class Handler {
	private Map<String, Runnable > options = new HashMap<String, Runnable >();
	private String args[];
	private Task task = new Task();

	public Handler(String args[]) {
		if (!this.isValidCommand(args)) {
			System.out.println("Invalid entry");
			return;
		}
		this.args = args;
		this.fillOptions();
		this.execute();
	}

	private void fillOptions () {
		options.put("add", () -> {
			this.task.add(this.args[1]);
		});
		options.put("update", () -> {
			this.task.update(this.args[1], this.args[2]);
		});
		options.put("list", () -> {
			this.task.listTasks();
		});
		options.put("delete", () -> System.out.println("Delete command"));
	}

	private boolean isValidCommand(String args[]) {
		return args.length > 0;
	}

	private void execute() {
		this.options.get(this.args[0]).run();
	}
}
