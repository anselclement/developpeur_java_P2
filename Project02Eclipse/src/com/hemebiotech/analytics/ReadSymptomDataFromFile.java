package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 * 
 * @author clement
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> GetSymptoms() {

		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	/**
	 * counts the number of occurrences of symptoms and integrates them into a Hash
	 * map
	 * 
	 * @throws IOException whenever an input or output operation is failed or
	 *                     interpreted
	 * 
	 * @see GetSymptoms
	 */

	public HashMap<String, Integer> CountSymptoms() throws IOException {

		HashMap<String, Integer> count = new HashMap<String, Integer>();

		try {
			List<String> listSymptoms = GetSymptoms();

			for (String Symptoms : listSymptoms) {

				if (count.containsKey(Symptoms)) {
					int v = count.get(Symptoms) + 1;
					count.put(Symptoms, v);
				} else {
					count.put(Symptoms, 1);
				}
			}

		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}

		return count;
	}

	/**
	 * use a treemap to have an alphabetically ordered list and then write this Tree
	 * map to a results.out file
	 * 
	 * @throws IOException IOException whenever an input or output operation is
	 *                     failed or interpreted
	 * 
	 * @see CountSymptoms()
	 */
	public void WriteSymptoms() throws IOException {

		TreeMap<String, Integer> transfert = new TreeMap<String, Integer>(CountSymptoms());

		try {
			PrintWriter results = new PrintWriter("Project02Eclipse/results.out");

			for (Map.Entry<String, Integer> entry : transfert.entrySet()) {
				results.write(entry.getKey() + " : " + entry.getValue() + "\r\n");
			}

			results.close();

		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
	}

}
