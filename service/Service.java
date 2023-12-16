package service;

import model.Animal;
import model.CommandForAnimal;
import presenter.Presenter;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
	private static Presenter presenter;
	public static void saveAnimalInFile (Animal animal, Boolean logical){
		try (FileWriter writer = new FileWriter(new File("HumanFriends.txt"), logical);) {
			try {
				writer.write(animal.getId() + ";");
				writer.write(animal.getName() + ";");
				writer.write(animal.getTypeAnimal() + ";");
				writer.write(animal.getBirthDayAnimal() + ";");
				writer.write(animal.getCategoryOfAnimal()+ ";");
				if(!animal.getCommandForAnimal().isEmpty()){
					writer.write(animal.getCommandForAnimal().toString().replaceAll("^\\[|\\]$", "") + ";\n");
				} else {writer.write("\n");}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void reWriteAnimalInFile (List<Animal> listAnimal) {
		int id = 1;
		for (Animal animal : listAnimal) {
			if (animal.getId() == 1) {
				animal.setId(id++);
				saveAnimalInFile(animal, false);
				continue;
			}
			animal.setId(id++);
			saveAnimalInFile(animal, true);
		}
	}

	public static ArrayList<Animal> loadAnimalFromFile() {
		String inputFileName = "FriendOfPeople.txt";
		List<Animal> list = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] lineData = line.split(";");
				List<CommandForAnimal> lst = getCommandsAnimalList(lineData);

				Animal animal = new Animal(Integer.parseInt(lineData[0]), lineData[1], lineData[2],
						LocalDate.parse(lineData[3]), lineData[4], (ArrayList<CommandForAnimal>) lst);
				list.add(animal);
			}

		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return (ArrayList<Animal>) list;
	}

	private static List<CommandForAnimal> getCommandsAnimalList(String[] lineData) {
		List<CommandForAnimal> lst = new ArrayList<>();
		if (lineData.length > 5) {
			String[] splitCommands = lineData[5].split(", ");
			for (String command : splitCommands) {
				String commandTrim = command.trim().replaceAll("\\s+", " ");
				if (commandTrim != "") {
					CommandForAnimal commandForAnimal = new CommandForAnimal(commandTrim);
					lst.add(commandForAnimal);
				}
			}
		}
		return lst;
	}
}
