package model;

import java.time.LocalDate;

public abstract class Sumpter extends Animal {
	public Sumpter(int id, String name, String typeAnimal, LocalDate birthDayAnimal, String category){
		super(id, name, typeAnimal, birthDayAnimal, category);
	}

	public Sumpter(String name, String typeAnimal, LocalDate birthDayAnimal, String category){
		super(name, typeAnimal, birthDayAnimal, category);
	}
}
