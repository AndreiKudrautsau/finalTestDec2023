package view.command;

import view.ConsoleUI;

public class AddAnimal extends Command {
	public AddAnimal(ConsoleUI consoleUI){
		super(consoleUI, "add new animal");
	}
	@Override
	public void execute(){
		consoleUI.addAnimal();
	}
}
