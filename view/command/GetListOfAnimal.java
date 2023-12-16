package view.command;

import view.ConsoleUI;

public class GetListOfAnimal extends Command{
	public GetListOfAnimal(ConsoleUI consoleUI){
		super(consoleUI, "receive list of animal");
	}

	@Override
	public void execute(){
		consoleUI.getListOfAnimal();
	}
}
