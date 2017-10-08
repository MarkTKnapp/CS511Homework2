package Assignment2;

import java.util.*;
import Assignment2.Gym.*;
import Assignment2.WeightPlateSize.*;

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

	public void run() {
		for(Exercise e: routine){
			System.out.println("Client " + id + " is doing exercise " + e.getApparatusTypeString());

			// Begin entry protocol
			try {
				Gym.accessApparatus[e.getApparatusTypeIndex()].acquire();
			} catch( InterruptedException ie){

			}

			int weights_3KG = e.getWeights().get(WeightPlateSizes.SMALL_3KG);
			int weights_5KG = e.getWeights().get(WeightPlateSizes.MEDIUM_5KG);
			int weights_10KG = e.getWeights().get(WeightPlateSizes.LARGE_10KG);
			for (int i = 0; i < weights_3KG; i++){
				try {
					Gym.getWeights[0].acquire();
				} catch( InterruptedException ie){

				}
			}
			for (int i = 0; i < weights_5KG; i++){
				try {
					Gym.getWeights[1].acquire();
				} catch( InterruptedException ie){

				}
			}
			for (int i = 0; i < weights_10KG; i++){
				try {
					Gym.getWeights[2].acquire();
				} catch( InterruptedException ie){

				}
			}
			// End entry protocol

			// Begin exit protocol
			Gym.accessApparatus[e.getApparatusTypeIndex()].release();

			for (int i = 0; i < weights_3KG; i++){
				Gym.getWeights[0].release();
			}
			for (int i = 0; i < weights_5KG; i++){
				Gym.getWeights[1].release();
			}
			for (int i = 0; i < weights_10KG; i++){
				Gym.getWeights[2].release();
			}
			// End exit protocol
		}
	}
}