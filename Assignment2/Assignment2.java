package Assignment2;

/**
 * @author      Mark Knapp
 * @author      Zach Hackett
 * @version     1.0                 (current version number of program)
 * CS511 Homework 2
 * October 6th, 2017
 * "I pledge my honor that I have abided by the Stevens Honor System"
 */

public class Assignment2 {
	public static void main(String[] args){
		Thread thread = new Thread(new Gym());
		thread.start();
		try {
			thread.join();
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
	}
}