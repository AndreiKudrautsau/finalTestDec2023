package model.object;

import model.Pet;

import java.time.LocalDate;

public class Hamster extends Pet {
	public Hamster(String name, String typeAnimal, LocalDate birthDayAnimal, String category){
		super(name, typeAnimal, birthDayAnimal, category);
	}
}
