package view;

import view.command.*;

import java.util.ArrayList;

public class Menu {
	private final ArrayList<Command> commandList;

	public Menu (ConsoleUI consoleUI){
		commandList = new ArrayList<>();
		commandList.add(new GetListOfAnimal(consoleUI));
		commandList.add(new AddAnimal(consoleUI));
		commandList.add(new SearchAnimal(consoleUI));
		commandList.add(new SortByBirthDayAnimal(consoleUI));
		commandList.add(new DeleteAnimal(consoleUI));
		commandList.add(new Finish(consoleUI));
	}

	public int getSize() {
		return commandList.size();
	}
	public String menu() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < commandList.size(); i++) {
			stringBuilder.append(i + 1);
			stringBuilder.append(". ");
			stringBuilder.append(commandList.get(i).getDescription());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

	public void execute(int choice) {
		Command command = commandList.get(choice - 1);
		command.execute();
		System.out.println("<><><><><><><><><><><><><>");
	}
}
