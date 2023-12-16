package model.object;

import model.Sumpter;

import java.time.LocalDate;

public class Donkey extends Sumpter {
	public Donkey(String name, String typeAnimal, LocalDate birthDayAnimal, String category){
		super(name, typeAnimal, birthDayAnimal, category);
	}
}
