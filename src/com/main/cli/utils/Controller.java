package com.main.cli.utils;

import com.main.cli.actions.Add;
import com.main.cli.actions.List;
import com.main.cli.actions.Update;

import java.util.HashMap;
import java.util.Map;

public class Controller {
	private Map<String, Runnable > options = new HashMap<>();
	private String args[];

	public Controller(String args[]) {
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
			Add action = new Add();
			action.execute(this.args[1]);
		});
		options.put("update", () -> {
			Update action = new Update();
			action.execute(this.args[1], this.args[2]);
		});
		options.put("list", () -> {
			List action = new List();
			action.execute();
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
