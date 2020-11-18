package com.hemebiotech.analytics;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

		ReadSymptomDataFromFile symptomFile = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");

		symptomFile.CountSymptoms();
	}
}
