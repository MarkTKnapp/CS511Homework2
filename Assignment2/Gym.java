package Assignment2;

import java.util.*;
import java.util.concurrent.*;
import Assignment2.WeightPlateSize.*;
/**
 * @author      Mark Knapp
 * @author      Zach Hackett
 * @version     1.0                 (current version number of program)
 * CS511 Homework 2
 * October 6th, 2017
 * "I pledge my honor that I have abided by the Stevens Honor System"
 */

public class Gym implements Runnable{
	private static final int GYM_SIZE = 30;
	private static final int GYM_REGISTERED_CLIENTS = 10000;
	private Map<WeightPlateSizes,Integer> noOfWeightPlates;
	private Set<Integer> clients; // for generating fresh client ids
	private ExecutorService executor;
	// various semaphores - declaration omitted
	public static Semaphore[] accessApparatus 	= new Semaphore[8];
	public static Semaphore[] getWeights		= new Semaphore[3];

	public Gym(){
		noOfWeightPlates = new HashMap<WeightPlateSizes, Integer>();
		noOfWeightPlates.put(WeightPlateSizes.SMALL_3KG, 110);
		noOfWeightPlates.put(WeightPlateSizes.MEDIUM_5KG, 90);
		noOfWeightPlates.put(WeightPlateSizes.LARGE_10KG, 75);

		executor = Executors.newFixedThreadPool(GYM_SIZE);

		for (int i = 0; i < 8; i++){
			accessApparatus[i] = new Semaphore(5);
		}
		getWeights[0] = new Semaphore(110);
		getWeights[1] = new Semaphore(90);
		getWeights[2] = new Semaphore(75);
	}

	public void run(){
		System.out.println("Starting gym");
		for (int i = 0; i < GYM_REGISTERED_CLIENTS; i++){
			executor.execute(Client.generateRandom(i));
		}
		executor.shutdown();
	}
}