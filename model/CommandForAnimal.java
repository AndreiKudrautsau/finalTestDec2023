package model;

public class CommandForAnimal {
	private String name;
	private String active;

	public CommandForAnimal(String name, String active){
		this.name = name;
		this.active = active;
	}

	public CommandForAnimal(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public String getActive(){
		return active;
	}

	@Override
	public String toString(){
		return name;
	}
}
