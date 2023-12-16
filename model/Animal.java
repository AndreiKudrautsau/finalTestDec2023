package model;

import view.command.Command;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Animal {
	private int id;
	private String name;
	private String typeAnimal;
	private LocalDate birthDayAnimal;
	private String categoryOfAnimal;
	private List<CommandForAnimal> commandForAnimal;

	public Animal(int id, String name, String typeAnimal, LocalDate birthDate, String category) {
		this.id = id;
		this.name = name;
		this.typeAnimal = typeAnimal;
		this.birthDayAnimal = birthDate;
		this.categoryOfAnimal = category;
		commandForAnimal = new ArrayList<>();
	}

	public Animal(String name, String typeAnimal, LocalDate birthDate, String category) {
		this.name = name;
		this.typeAnimal = typeAnimal;
		this.birthDayAnimal = birthDate;
		this.categoryOfAnimal = category;
		commandForAnimal = new ArrayList<>();
	}

	public Animal(int id, String name, String typeAnimal, LocalDate birthDate, String category, ArrayList<CommandForAnimal> commandsAnimal) {
		this.id = id;
		this.name = name;
		this.typeAnimal = typeAnimal;
		this.birthDayAnimal = birthDate;
		this.categoryOfAnimal = category;
		this.commandForAnimal = commandsAnimal;
	}

	public Animal(Animal animal) { }

	public Animal() { }


	public  int getId(){
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName(){
		return name;
	}

	public String getTypeAnimal(){
		return typeAnimal;
	}

	public void setTypeAnimal(String typeAnimal){
		this.typeAnimal = typeAnimal;
	}

	public LocalDate getBirthDayAnimal(){
		return birthDayAnimal;
	}

	public void setBirthDayAnimal(LocalDate birthDayAnimal){
		this.birthDayAnimal = birthDayAnimal;
	}

	public String getCategoryOfAnimal(){
		return categoryOfAnimal;
	}

	public void setCategoryOfAnimal(String categoryOfAnimal){
		this.categoryOfAnimal = categoryOfAnimal;
	}

	public List<CommandForAnimal> getCommandForAnimal(){
		return commandForAnimal;
	}

	public void addCommandForAnimal(CommandForAnimal newCommand) {
		if(!commandForAnimal.contains(newCommand)){
			commandForAnimal.add(newCommand);
		}
		else {
			System.out.println("Don't add. Command is exist.");
		}
	}
	@Override
	public String toString() {
		return getInfoAnimal();
	}

	public String getInfoAnimal(){
		String inf = id + " name: " + name +
				"| type: " + typeAnimal +
				"| birthday: " + birthDayAnimal +
				"| skills: " + categoryOfAnimal + "|";
		return inf;
	}
}
