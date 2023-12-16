package presenter;

import model.Animal;
import model.object.*;
import service.FarmOfAnimal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presenter {
	private final FarmOfAnimal farmOfAnimal;

	public Presenter(){
		farmOfAnimal = new FarmOfAnimal();
	}

	public ArrayList<Animal> getListOfAnimal(){
		ArrayList<Animal> answer = farmOfAnimal.getListOfAnimal();
		return answer;
	}

	public Animal addAnimal(String name, String typeAnimal, LocalDate birthDayAnimal, String categoryOfAnimal){
		Animal animal = switch (typeAnimal){
			case "Cat" -> new Cat(name, typeAnimal, birthDayAnimal, categoryOfAnimal);
			case "Camel" -> new Camel(name, typeAnimal, birthDayAnimal, categoryOfAnimal);
			case "Dog" -> new Dog(name, typeAnimal, birthDayAnimal, categoryOfAnimal);
			case "Donkey" -> new Donkey(name, typeAnimal, birthDayAnimal, categoryOfAnimal);
			case "Hamster" -> new Hamster(name, typeAnimal, birthDayAnimal, categoryOfAnimal);
			case "Horse" -> new Horse(name, typeAnimal, birthDayAnimal, categoryOfAnimal);
			default -> throw new IllegalStateException("Unexpected value: " + typeAnimal);

		};
		farmOfAnimal.addAnimal(name, typeAnimal, birthDayAnimal, categoryOfAnimal);
		return animal;
	}

	public void searchAnimal(String value) {
		String answerSearch = String.valueOf(farmOfAnimal.searchAnimal(value));
		System.out.println(answerSearch);
	}

	public int deleteAnimal(Animal animal){
		if (animal == null) return -1;
		return farmOfAnimal.deleteAnimal(animal);
	}

	public void getInfoAnimal(Animal animal) {
		if (animal == null) System.out.println(":)");
		farmOfAnimal.getInfoAnimal(animal);
	}

	public void addCommandForAnimal(Animal animal){
		farmOfAnimal.addCommandForAnimal(animal);
	}

	public void sortByBirthDayAnimal(){
		farmOfAnimal.sortByBirthDayAnimal();
		getListOfAnimal();
	}

	public void countAnimal(){
		farmOfAnimal.countAnimal();
	}
}
