package view.command;

import model.Animal;
import view.ConsoleUI;

public class TrainAnimal extends Command{

	public TrainAnimal(ConsoleUI consoleUI){
		super(consoleUI, "train animal");
	}

	@Override
	public void execute(){

	}
}
