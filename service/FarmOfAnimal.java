package service;

import model.Animal;
import model.CommandForAnimal;
import service.comparator.AnimalComparatorByBirthDay;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FarmOfAnimal implements Serializable {
	public List<Animal> animalList;
	public List<CommandForAnimal> commandForAnimalList;
	public Animal animal;

	public FarmOfAnimal (List<Animal> animalList){
		this.animalList = Service.loadAnimalFromFile();
		this.commandForAnimalList = commandForAnimalList;
		this.animal = animal;
	}

	public FarmOfAnimal() {
		this(new ArrayList<>());
	}

	public ArrayList<Animal> getListOfAnimal(){
		List<Animal> listAnimal = Service.loadAnimalFromFile();
		System.out.println("List of farm:");
		for (Animal animal: listAnimal) {
			System.out.printf(animal.getId() +
					". name: " + animal.getName() +
					", type: " + animal.getTypeAnimal() +
					", category: " + animal.getCategoryOfAnimal() +
					", birthday: " + animal.getBirthDayAnimal() +
					", skills: " + animal.getCommandForAnimal().toString().replaceAll("^\\[|\\]$", "") +";\n");
		}
		return (ArrayList<Animal>) animalList;
	}

	public Animal addAnimal(String name, String typeAnimal, LocalDate birthDayAnimal, String categoryAnimal) {
		Animal animal = new Animal(name, typeAnimal, birthDayAnimal, categoryAnimal);
		if (!animalList.contains(animal)) {
			animal.setId(getListOfAnimal().size() + 1);
			animalList.add(animal);
			Service.saveAnimalInFile(new Animal(animal.getId(), name, typeAnimal, birthDayAnimal, categoryAnimal), true);
		}
		return animal;
	}

	public Animal searchAnimal(String value) {
		List<Animal> listAnimal = Service.loadAnimalFromFile();
		LocalDate date = LocalDate.parse(value);
		for (Animal animal: listAnimal) {
			if (animal.getBirthDayAnimal().isEqual(date)){
				return animal;
			}
		}
		return null;
	}


	public int deleteAnimal(Animal animal) {
		if (!animalList.contains(animal.getId())) {
			System.out.println("++++++++++++++");
			Animal deleteAnimal = animalList.remove(animal.getId()-1);
			System.out.println("!!! note is delete  ->  " + deleteAnimal);
			Service.reWriteAnimalInFile(animalList); // проработать сохранение в файл с заменой данных и изм.-ми id
			System.out.println("***************");
			return deleteAnimal.getId();
		}
		return -1;
	}

	public void getInfoAnimal(Animal animal) {
		System.out.println();
		System.out.print("~~~~~~ card of animal ~~~~~~\n");
		System.out.printf(animal.getId() + "." + "name: %s", animal.getName()+ ",\n");
		System.out.printf("  type: " + animal.getTypeAnimal() + " ," + "category: " + animal.getCategoryOfAnimal() + ",\n");
		System.out.printf("  birthday: " + animal.getBirthDayAnimal() + ")" + "\n");
		System.out.printf("  skills: %s\n", animal.getCommandForAnimal().toString().replaceAll("^\\[|\\]$", ""));
		System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}

	public void countAnimal() {
		int countNursery = 0;
		int countPets = 0;
		int countPackAnimal = 0;
		for (Animal animal : animalList) {
			countNursery += 1;
			if (animal.getTypeAnimal().equalsIgnoreCase("Dog") ||
					animal.getTypeAnimal().equalsIgnoreCase("Cat") ||
					animal.getTypeAnimal().equalsIgnoreCase("Hamster")) {
				countPets += 1;
			}
			if (animal.getTypeAnimal().equalsIgnoreCase("Horse") ||
					animal.getTypeAnimal().equalsIgnoreCase("Camel") ||
					animal.getTypeAnimal().equalsIgnoreCase("Donkey")) {
				countPackAnimal += 1;
			}
		}
		System.out.println("     Total: " + countNursery +
				"( pet - " + countPets + " , sumpter - " + countPackAnimal + ")");
	}

	public void addCommandForAnimal (Animal animal) {
		deleteAnimal(animal);
		Service.saveAnimalInFile(animal, true);
	}

	public void sortByBirthDayAnimal() { animalList.sort(new AnimalComparatorByBirthDay());}

}
