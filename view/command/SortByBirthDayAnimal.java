package view.command;

import view.ConsoleUI;

public class SortByBirthDayAnimal extends Command{
	public SortByBirthDayAnimal(ConsoleUI consoleUI){
		super(consoleUI, "sort animal by birthday");
	}

	@Override
	public void execute(){
		consoleUI.sortByBirthDayAnimal();
	}

}
