package Assignment2;

import java.util.*;
import Assignment2.Gym.*;

/**
 * @author      Mark Knapp
 * @author      Zach Hackett
 * @version     1.0                 (current version number of program)
 * CS511 Homework 2
 * October 6th, 2017
 * "I pledge my honor that I have abided by the Stevens Honor System"
 */

public class Client implements Runnable{
	private int id;
	private List<Exercise> routine;
	public static Random rand = new Random();

	public Client(int id){
		this.id = id;
		routine = new ArrayList<Exercise>();
	}

	public void addExercise(Exercise e){
		routine.add(e);
	}

	public static Client generateRandom(int id){
		int totalExercises = (int)(Math.round(rand.nextDouble() * 5.0)) + 15;

		Client returnClient = new Client(id);

		for (int i = 0; i < totalExercises; i++){
			returnClient.addExercise(Exercise.generateRandom(null));
		}
		return returnClient;
	}

	public void run(){
		for(Exercise e: routine){
			System.out.println("Client " + id + " is doing exercise " + e.getApparatusTypeString());
			
		}
	}
}