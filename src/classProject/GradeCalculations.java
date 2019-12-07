package classProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GradeCalculations {
	
	private int highBound;
	private int lowBound;
	
	private double highValue;
	private double lowValue;
	private double mean;
	private double median;
	private double mode;
	private ArrayList<String> errorMessages;
	private ArrayList<Double> scoresList;
	
	
	
	
	public ArrayList<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(ArrayList<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public ArrayList<Double> getScoresList() {
		return scoresList;
	}

	public void setScoresList(ArrayList<Double> scoresList) {
		this.scoresList = scoresList;
	}

	public double getMean() {
		return mean;
	}

	public void setMean(double mean) {
		this.mean = mean;
	}

	public double getMedian() {
		return median;
	}

	public void setMedian(double median) {
		this.median = median;
	}

	public double getMode() {
		return mode;
	}

	public void setMode(double mode) {
		this.mode = mode;
	}
	
	public int getHighBound() {
		return highBound;
	}

	public void setHighBound(int highBound) {
		this.highBound = highBound;
	}

	public int getLowBound() {
		return lowBound;
	}

	public void setLowBound(int lowBound) {
		this.lowBound = lowBound;
	}

	public double getHighValue() {
		return highValue;
	}

	public void setHighValue(double highValue) {
		this.highValue = highValue;
	}

	public double getLowValue() {
		return lowValue;
	}

	public void setLowValue(double lowValue) {
		this.lowValue = lowValue;
	}


	public GradeCalculations() {
		errorMessages  = new ArrayList<String>();
		scoresList = new ArrayList<Double>();
		mean = 0;
		median = 0;
		mode = 0;
		highBound = 100;
		lowBound = 0;
	}
	
	//this was everything in the main from this file
	public void tester() throws Exception {
		//create array of grades
		ArrayList<Double> scoresList = new ArrayList<Double>();
		scoresList.add(78.6);
		scoresList.add(88.4);
		scoresList.add(65.2);
		scoresList.add(65.2);
		scoresList.add(65.2);
		scoresList.add(91.5);
		scoresList.add(95.4);
		scoresList.add(52.7);
		scoresList.add(87.6);
		scoresList.add(21.55);
		//scoresList.add(121.55);
		//create scanner to read keyboard inputs
		
		//high = 100;
		//low = 0;
		
		checkBoundaries(scoresList);
		
		System.out.println("Highest Value: "+ getHigh(scoresList));
		System.out.println("Lowest Value: "+getLow(scoresList));
		System.out.println("Median: "+median(scoresList));
		System.out.println("Mean: "+mean(scoresList));
		System.out.println("Mode: "+mode(scoresList));
	}
	
	void updateAll() {
		if(scoresList.size() > 0) {
			highValue = getHigh(scoresList);
			lowValue = getLow(scoresList);
			median = median(scoresList);
			mean = mean(scoresList);
			mode = mode(scoresList);
		}
	}

	double getHigh(ArrayList<Double> scoresList) {
		double max = 0;
		
		for(int i = 0; i < scoresList.size(); i++) {
			double currentVal = scoresList.get(i);
			if( currentVal > max) {
				max = currentVal;
			}
		}
		
		return max; 
		
	}
	
	double getLow(ArrayList<Double> scoresList) {
		double min = Double.MAX_VALUE;
		for(int i = 0; i < scoresList.size(); i++) {
			double currentVal = scoresList.get(i);
			if( currentVal < min) {
				min = currentVal;
			}
		}
		
		
		return min;
	}
	
	double median(ArrayList<Double> scoresList) {
		double median = 0;
		Collections.sort(scoresList);
		if (scoresList.size() > 1) {
			//if even || odd 
			if (scoresList.size() % 2 == 0)
			    median = ( ((double)scoresList.get(scoresList.size()/2) + (double)scoresList.get(scoresList.size()/2 - 1)) /2);
			else
			    median = (double) scoresList.get(scoresList.size()/2);
		}else {
			//System.out.println("There is not enough data to calculate a median");
			addNewError("There is not enough data to calculate a median");
		}

		return median;
	}
	
	double mean(ArrayList<Double> scoresList) {
		double mean = 0;
		if(!scoresList.isEmpty()) {
			if(scoresList.size() <=1) {
				addNewError("There are not enough scores to calculate mean");
			}
			for(int i = 0; i < scoresList.size(); i++ ) {
				mean += scoresList.get(i);
			}
			//System.out.println("Printing list size " + scoresList.size());
			//System.out.println("Printing mean  " + mean);
			mean = mean/scoresList.size();
		}else {
			addNewError("There are no scores, please add scores and continue");
		}
		return mean;
	}
	
	double mode(ArrayList<Double> scoresList) {
		double mode = scoresList.get(0);
		double max = 0;
		for(int i = 0; i < scoresList.size(); i++) {
			double value = scoresList.get(i);
			int count = 0;
			
			for (int j =0; j < scoresList.size(); j++) {
				if(scoresList.get(j) == value) {
					count ++;
				}
				if(count > max) {
					mode = value;
					max = count;
				}
			}
		}
		
		if(max > 1) {
			return mode;
		}else {
			addNewError("There is no mode for the given data");
			return 0.0;
		}
		
	}
	
	void delete(String value, ArrayList<Double> scoresList) {
		int counter = 0;
		boolean elementFoundFlag = false;
		
		while (0 < scoresList.size() && elementFoundFlag == false)
		{
		   if(scoresList.get(counter).equals(value))
		   {
		     // Remove item
			  scoresList.remove(counter);
			  elementFoundFlag = true;
		  }
		  else
		  {
		    ++counter;
		  }
		}
		
	}
	
	void checkBoundaries(ArrayList<Double> scoresList) throws Exception {
		int length = scoresList.size();
		
		for(int i = 0; i < length; i++){
			double temp = scoresList.get(i);
			//check to determine if there are violations of the boundaries
			if(temp > highBound || temp < lowBound){
				addNewError("Data Element at index: " + i + " is out of bounds");
				
				//remove the violating data and recalculate values
				
				throw new Exception("Data Element at index: " + i + " is out of bounds");
			}
		}
	}
	
	void sort(ArrayList<Double> scoresList) {
		Collections.sort(scoresList);
	}
	
	void determineDistribution() {
		int bucketSize =  (int) Math.floor(highBound/lowBound); 
	}
	
	void addNewError(String newMessage) {
		errorMessages.add(newMessage);
	}
	
	void printArray() {
		errorMessages.forEach(error -> {;
			System.out.println(error);
		});
	}
	
	
	
	
	
}
