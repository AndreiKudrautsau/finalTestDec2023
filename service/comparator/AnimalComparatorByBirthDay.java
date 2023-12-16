package service.comparator;

import model.Animal;
import service.AnimalItem;

import java.util.Comparator;

public class AnimalComparatorByBirthDay<Animal extends AnimalItem> implements Comparator<model.Animal> {
	@Override
	public int compare(model.Animal o1, model.Animal o2){
		return o1.getBirthDayAnimal().compareTo(o2.getBirthDayAnimal());
	}
}
