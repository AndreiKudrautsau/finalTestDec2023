package model.object;

import model.Pet;

import java.time.LocalDate;

public class Cat extends Pet {
	public Cat(String name, String typeAnimal, LocalDate birthDayAnimal, String category){
		super(name, typeAnimal, birthDayAnimal, category);
	}
}
