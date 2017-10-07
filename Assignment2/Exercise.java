package Assignment2;

import java.util.*;
import java.util.Random;
import Assignment2.WeightPlateSize.*;
import Assignment2.ApparatusType.*;
/**
 * @author      Mark Knapp
 * @author      Zach Hackett
 * @version     1.0                 (current version number of program)
 * CS511 Homework 2
 * October 6th, 2017
 * "I pledge my honor that I have abided by the Stevens Honor System"
 */

public class Exercise {
	private ApparatusTypes at;
	private Map<WeightPlateSize, Integer> weight;
	private int duration;
	public static Random rand = new Random();

	public Exercise(ApparatusTypes at, Map<WeightPlateSize, Integer> weight, int duration){
		this.at 		= at;
		this.weight 	= weight;
		this.duration 	= duration;
	}

	public static Exercise generateRandom(Map<WeightPlateSize, Integer> weight){
		Map<WeightPlateSizes, Integer> selectedWeights = new HashMap<WeightPlateSizes, Integer>();

		int rand1 	 = (int)(rand.nextDouble() * 10);
		int rand2 	 = (int)(rand.nextDouble() * (10 - rand1));
		int rand3 	 = (int)(rand.nextDouble() * (10 - rand2 - rand1));
		int duration = (int)((rand.nextDouble() * 4999) + 1);

		if (rand1 + rand2 + rand3 == 0){
			rand2 = 1;
		}

		selectedWeights.put(WeightPlateSizes.SMALL_3KG, rand1);
		selectedWeights.put(WeightPlateSizes.MEDIUM_5KG, rand2);
		selectedWeights.put(WeightPlateSizes.LARGE_10KG, rand3);
		
		return new Exercise(ApparatusTypes.values()[(rand.nextInt() & 0x07)], weight, duration);
	}

	public String getApparatusTypeString(){
		switch (at){
			case LEGPRESSMACHINE:
				return "Legpress Machine";
			case BARBELL:
				return "Barbell";
			case HACKSQUATMACHINE:
				return "Hacksquat Machine";
			case LEGEXTENSIONMACHINE:
				return "Leg Extension Machine";
			case LEGCURLMACHINE:
				return "Leg Curl Machine";
			case LATPULLDOWNMACHINE:
				return "Lat Pulldown Machine";
			case PECDECKMACHINE:
				return "Pec Deck Machine";
			case CABLECROSSOVERMACHINE:
				return "Cable Crossover Machine";
		}
		return "None";
	}

}