package classProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GradeCalculations {
	
	static double high;
	static double low;
	
	public GradeCalculations() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//create array of grades
		ArrayList<Double> scoresList = new ArrayList<Double>();
		scoresList.add(78.6);
		scoresList.add(88.4);
		scoresList.add(65.2);
		scoresList.add(91.5);
		scoresList.add(95.4);
		scoresList.add(52.7);
		scoresList.add(87.6);
		scoresList.add(21.55);
		//scoresList.add(121.55);
		//create scanner to read keyboard inputs
		
		high = 100;
		low = 0;
		
		checkBoundaries(scoresList);
		
		System.out.println("Highest Value: "+getHigh(scoresList));
		System.out.println("Lowest Value: "+getLow(scoresList));
		System.out.println("Median: "+median(scoresList));
		System.out.println("Mean: "+mean(scoresList));
		System.out.println("Mode: "+mode(scoresList));

	}
	
	void readFile() {
	}
	

	static double getHigh(ArrayList<Double> scoresList) {
		double max = 0;
		
		for(int i = 0; i < scoresList.size(); i++) {
			double currentVal = scoresList.get(i);
			if( currentVal > max) {
				max = currentVal;
			}
		}
		
		return max; 
		
	}
	
	static double getLow(ArrayList<Double> scoresList) {
		double min = Double.MAX_VALUE;
		for(int i = 0; i < scoresList.size(); i++) {
			double currentVal = scoresList.get(i);
			if( currentVal < min) {
				min = currentVal;
			}
		}
		
		
		return min;
	}
	
	static double median(ArrayList<Double> scoresList) {
		double median = 0;
		Collections.sort(scoresList);
		if (scoresList.size() > 1) {
			//if even || odd 
			if (scoresList.size() % 2 == 0)
			    median = ( ((double)scoresList.get(scoresList.size()/2) + (double)scoresList.get(scoresList.size()/2 - 1)) /2);
			else
			    median = (double) scoresList.get(scoresList.size()/2);
		}else {
			System.out.println("There is not enough data to calculate a median");
		}

		return median;
	}
	
	static double mean(ArrayList<Double> scoresList) {
		double mean = 0;
		if(!scoresList.isEmpty()) {
			for(int i = 0; i < scoresList.size(); i++ ) {
				mean += scoresList.get(i);
			}
			//System.out.println("Printing list size " + scoresList.size());
			//System.out.println("Printing mean  " + mean);
			mean = mean/scoresList.size();
		}
		return mean;
	}
	
	static double mode(ArrayList<Double> scoresList) {
		double mode = 0;
		int count = -1; 
		int tempCount = 0;
		Collections.sort(scoresList);
		
		for(int i = 0; i < scoresList.size() - 1; i++) {
			if(scoresList.get(i) == scoresList.get(i+1)) {
				tempCount++;
			}
			if(tempCount > count) {
				mode = scoresList.get(i);
				count  = tempCount;
			}
			
		}
		return mode;
	}
	
	static void checkBoundaries(ArrayList<Double> scoresList) throws Exception {
		int length = scoresList.size();
		
		for(int i = 0; i < length; i++){
			double temp = scoresList.get(i);
			if(temp > high || temp < low){
				throw new Exception("Data Element at index: " + i + " is out of bounds");
			}
		}
	}
	
	static void sort(ArrayList<Double> scoresList) {
		Collections.sort(scoresList);
	}
	
	static void graphs(){
		
	}
	
	
	
}
