package view.command;

import view.ConsoleUI;

public class Finish extends Command {
	public Finish(ConsoleUI consoleUI){
		super(consoleUI, "exit");
	}
	@Override
	public void execute(){
		consoleUI.finish();
	}
}
