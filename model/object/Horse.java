package model.object;

import model.Sumpter;

import java.time.LocalDate;

public class Horse extends Sumpter {
	public Horse(String name, String typeAnimal, LocalDate birthDayAnimal, String category){
		super(name, typeAnimal, birthDayAnimal, category);
	}
}
