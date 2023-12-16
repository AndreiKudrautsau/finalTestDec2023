package model;

import java.time.LocalDate;

public abstract class Pet extends Animal {
	public Pet(int id, String name, String typeAnimal, LocalDate birthDayAnimal, String category){
		super(id, name, typeAnimal, birthDayAnimal, category);
	}
	public Pet(String name, String typeAnimal, LocalDate birthDayAnimal, String category){
		super(name, typeAnimal, birthDayAnimal, category);
	}

}
