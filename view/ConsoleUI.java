package view;

import model.Animal;
import model.CommandForAnimal;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
	private boolean work;
	private Scanner scanner;
	private final Menu mainMenu;
	private final Presenter presenter;


	public ConsoleUI() {
		this.work = true;
		this.scanner = new Scanner(System.in);
		mainMenu = new Menu(this);
		this.presenter = new Presenter();
	}

	@Override
	public void start() {

		System.out.println("list:");
		System.out.println();
		countAnimals();

		while (work) {
			System.out.println(mainMenu.menu());
			String choice = scanner.nextLine();
			int numChoice = Integer.parseInt(choice);
			if( 1 <= numChoice && numChoice <= 8){
				mainMenu.execute(numChoice);
			}else {
				System.out.println(" ->>> enter right!");
				start();
			}
		}
	}

	public void finish(){
		System.out.println("program is complete!");
		work = false;
	}

	public void getListOfAnimal() {
		presenter.getListOfAnimal();
	}

	public void addAnimal() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name");
		String name = scanner.nextLine();
		String typeAnimal;
		do {
			System.out.println("Enter type (format: Dog, Cat, Hamster, Horse, Camel, Donkey)");
			typeAnimal = scanner.nextLine();
		} while (!typeAnimal.equalsIgnoreCase("Dog") && !typeAnimal.equalsIgnoreCase("Cat")
				&& !typeAnimal.equalsIgnoreCase("Hamster") && !typeAnimal.equalsIgnoreCase("Horse")
				&& !typeAnimal.equalsIgnoreCase("Camel") && !typeAnimal.equalsIgnoreCase("Donkey"));

		System.out.println("Enter birthday (format: 2023-12-20)");
		String birthdayString = scanner.nextLine();
		LocalDate birthDayAnimal = LocalDate.parse(birthdayString);

		String categoryAnimal;
		do {
			System.out.println("Enter category (format: Pets или PackAnimal)");
			categoryAnimal = scanner.nextLine();
		} while (!categoryAnimal.equalsIgnoreCase("Pets") &&
				!categoryAnimal.equalsIgnoreCase("PackAnimal"));
		presenter.addAnimal(name, typeAnimal, birthDayAnimal, categoryAnimal);
	}

	public String searchAnimal() {
		System.out.println("Enter for search <birthday> (format: 2023-12-20)");
		String value = scanner.nextLine();
		presenter.searchAnimal(value);
		return value;
	}


	public void SortByBirthDayAnimal() {presenter.sortByBirthDayAnimal();}

	public void countAnimals() { presenter.countAnimal(); }
	public int deleteAnimal() {
		String request = String.format("Enter number of animal for delete (1 - %d)",
				presenter.getListOfAnimal().size());
		System.out.println(request);
		while (true) {
			try {
				scanner = new Scanner(System.in);
				int number = scanner.nextInt();
				Animal animal = presenter.getListOfAnimal().get(number - 1);
				presenter.deleteAnimal(animal);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Number is not exist!");
			}
			start();
		}
	}


	public boolean trainAnimal(Animal animal) {
		System.out.println("Enter: task:description (format voice: voice)");
		scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		if (input.isBlank()) return false;
		String[] commandData = input.split(":");
		if (commandData.length == 1) {
			animal.addCommandForAnimal(new CommandForAnimal(commandData[0]));
			presenter.addCommandForAnimal(animal);
		} else if (commandData.length == 2) {
			animal.addCommandForAnimal(new CommandForAnimal(commandData[0], commandData[1]));
			presenter.addCommandForAnimal(animal);
		} else {
			System.out.println("incorrect format of data");
			return trainAnimal(animal);
		}
		return true;
	}

	@Override
	public void answer(String text) {
		System.out.println(text);
	}

	public void sortByBirthDayAnimal() {
	}
}
