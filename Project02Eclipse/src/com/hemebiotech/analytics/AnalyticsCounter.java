package com.hemebiotech.analytics;

/**
 * 
 * @author clement
 *
 */
public class AnalyticsCounter {

	/**
	 * The main method is where the file symptoms.txt is read
	 * 
	 * @param args
	 * @throws Exception
	 */

	public static void main(String args[]) throws Exception {

		ReadSymptomDataFromFile symptomFile = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");

		symptomFile.CountSymptoms();
	}
}
