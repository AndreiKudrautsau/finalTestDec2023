package view.command;

import view.ConsoleUI;

public class SearchAnimal extends Command {
	public SearchAnimal(ConsoleUI consoleUI){
		super(consoleUI, "search animal");
	}

	@Override
	public void execute(){
		consoleUI.searchAnimal();
	}
}
