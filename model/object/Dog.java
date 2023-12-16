package model.object;

import model.Pet;

import java.time.LocalDate;

public class Dog extends Pet {
	public Dog(String name, String typeAnimal, LocalDate birthDayAnimal, String category){
		super(name, typeAnimal, birthDayAnimal, category);
	}
}
