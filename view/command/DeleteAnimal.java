package view.command;

import view.ConsoleUI;

public class DeleteAnimal extends Command{
	public DeleteAnimal(ConsoleUI consoleUI){
		super(consoleUI, "delete animal from farm");
	}

	@Override
	public void execute(){
		consoleUI.deleteAnimal();
	}
}
