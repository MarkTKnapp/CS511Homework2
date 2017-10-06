package Assignment2;

import java.util.Random;
import Assignment2.WeightPlateSize;
/**
 * @author      Mark Knapp
 * @author      Zach Hackett
 * @version     1.0                 (current version number of program)
 * CS511 Homework 2
 * October 6th, 2017
 * "I pledge my honor that I have abided by the Stevens Honor System"
 */

public class Exercise {
	private ApparatusType at;
	private Map<WeightPlateSize, Integer> weight;
	private int duration;
	public static Random rand = new Random();

	public Exercise(ApparatusType at, Map<WeightPlateSize, Integer> weight, int duration){
		this.at 		= at;
		this.weight 	= weight;
		this.duration 	= duration;
	}

	public static Exercise generateRandom(Map<WeightPlateSize, Integer> weight){
		Map<WeightPlateSize, Integer> selectedWeights = new HashMap<WeightPlateSize, Integer>();

		int rand1 	 = rand.nextDouble * 10;
		int rand2 	 = rand.nextDouble * (10 - rand1);
		int rand3 	 = rand.nextDouble * (10 - rand2 - rand1);
		int duration = (rand.nextDouble() * 4999) + 1;

		if (rand1 + rand2 + rand3 == 0){
			rand2 = 1;
		}

		selectedWeights.put(WeightPlateSizes.SMALL_3KG, rand1);
		selectedWeights.put(WeightPlateSizes.MEDIUM_5KG, rand2);
		selectedWeights.put(WeightPlateSizes.LARGE_10KG, rand3);

		return new Exercise(ApparatusType.values()[rand.next(4)], weight, duration);
	}

}