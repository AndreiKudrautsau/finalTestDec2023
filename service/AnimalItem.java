package service;

import model.Animal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface AnimalItem extends Serializable {
	ArrayList<Animal> getListOfAnimal();
	Iterator<Animal> iterator();
	int deleteAnimal(Animal animal);
	void getInfoAnimal(Animal animal);
}
