package classProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * This class performs all the necessary calculations for the scores dataset
 * @author 
 *
 */
public class GradeCalculations {
	
	private int highBound;
	private int lowBound;
	
	private double highValue;
	private double lowValue;
	private double mean;
	private double median;
	private double mode;
	public ArrayList<String> errorMessages;
	public ArrayList<Double> scoresList;
	
	//Create ArrayLists to store each distribution
	public ArrayList<Double> zeroToNine;
	public ArrayList<Double> tenToNineteen;
	public ArrayList<Double> twentyToTwentynine;
	public ArrayList<Double> thirtyToThirtynine;
	public ArrayList<Double> fortyToFortynine;
	public ArrayList<Double> fiftyToFiftynine;
	public ArrayList<Double> sixtyToSixtynine;
	public ArrayList<Double> seventyToSeventynine;
	public ArrayList<Double> eightyToEightynine;
	public ArrayList<Double> ninetyToHundred;
	
	
	/**
	 * 
	 * @return
	 */
	public double getMean() {
		return mean;
	}
	/**
	 * 
	 * @param mean
	 */
	public void setMean(double mean) {
		this.mean = mean;
	}
	
	/**
	 * 
	 * @return median value
	 */
	public double getMedian() {
		return median;
	}
	
	/**
	 * 
	 * @param median
	 */
	public void setMedian(double median) {
		this.median = median;
	}
	
	/**
	 * 
	 * @return mode value
	 */
	public double getMode() {
		return mode;
	}
	
	/**
	 * 
	 * @param mode 
	 */
	public void setMode(double mode) {
		this.mode = mode;
	}
	/**
	 * 
	 * @return
	 */
	public int getHighBound() {
		return highBound;
	}
	/**
	 * 
	 * @param highBound
	 */
	public void setHighBound(int highBound) {
		this.highBound = highBound;
	}
	/**
	 * 
	 * @return
	 */
	public int getLowBound() {
		return lowBound;
	}
	/**
	 * 
	 * @param lowBound
	 */
	public void setLowBound(int lowBound) {
		this.lowBound = lowBound;
	}
	/**
	 * 
	 * @return
	 */
	public double getHighValue() {
		return highValue;
	}
	/**
	 * 
	 * @param highValue
	 */
	public void setHighValue(double highValue) {
		this.highValue = highValue;
	}
	/**
	 * 
	 * @return
	 */
	public double getLowValue() {
		return lowValue;
	}
	/**
	 * 
	 * @param lowValue
	 */
	public void setLowValue(double lowValue) {
		this.lowValue = lowValue;
	}

	/**
	 * This function initializes values for calculations
	 */
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
	/**
	 * This method has been implemented to manually test valyes
	 * @throws Exception
	 */
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
	/**
	 * This method will call all of the calculations again to update the values
	 */
	void updateAll() {
		highValue = getHigh(scoresList);
		lowValue = getLow(scoresList);
		median = median(scoresList);
		mean = mean(scoresList);
		mode = mode(scoresList);
	}
	
	/**
	 * 
	 * @param scoresList
	 * @return finds the maximum value in the dataset
	 */
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
	
	/**
	 * 
	 * @param scoresList
	 * @return finds the smallest value in the dataset
	 */
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
	
	/**
	 * 
	 * @param scoresList
	 * @return finds the median value of the dataset
	 */
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
	
	/**
	 * 
	 * @param scoresList
	 * @return calculates the mean of the dataset
	 */
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
	
	/**
	 * 
	 * @param scoresList
	 * @return calculates the mode of the dataset
	 */
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
	
	/**
	 * This method takes a value and checks if it is part of the dataset and deletes the first instance found. 
	 * @param value
	 * @param scoresList
	 */
	void delete(double value, ArrayList<Double> scoresList) {
		int counter = 0;
		boolean elementFoundFlag = false;
		if(scoresList.size() == 0) {
			addNewError("The dataset is empty, delete can't be performed");
		}else {
			try {
				while (0 < scoresList.size() && elementFoundFlag == false)
				{
				   if(scoresList.get(counter) == (value))
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
			}catch(Exception e) {
				  addNewError("Error performing deletion, item not available");
			}
			
			
		}
		
	}
	
	/**
	 * This method checks values in the dataset to make sure they conform to the boundary defined by the user/default boundary
	 * @param scoresList
	 * @throws Exception
	 */
	void checkBoundaries(ArrayList<Double> scoresList) throws Exception {
		int length = scoresList.size();
		
		for(int i = 0; i < length; i++){
			double temp = scoresList.get(i);
			//check to determine if there are violations of the boundaries
			if(temp > highBound || temp < lowBound){
				addNewError("Data Element at index: " + i + " is out of bounds");
				
				//remove the violating data and recalculate values
				delete(temp,  scoresList);
				updateAll();
				throw new Exception("Data Element at index: " + i + " is out of bounds");
			}
		}
	}
	
	/**
	 * This function can be used to sort the dataset
	 * @param scoresList
	 */
	void sort(ArrayList<Double> scoresList) {
		Collections.sort(scoresList);
	}
	
	/**
	 *  
	 */
	void determineDistribution(ArrayList<Double> scoresList) {
		int bucketSize =  (int) Math.floor(highBound/lowBound); 
		
		for(int i = 0; i < scoresList.size(); i ++) {
			double average = scoresList.get(i)/highBound;
			

			
			if(average >= 0 && average <= 9) {
				zeroToNine.add(scoresList.get(i));
			}
			if(average >= 10 && average <= 19) {
				tenToNineteen.add(scoresList.get(i));
			}
			if(average >= 20 && average <= 29) {
				twentyToTwentynine.add(scoresList.get(i));
			}
			if(average >= 30 && average <= 39) {
				thirtyToThirtynine.add(scoresList.get(i));
			}
			if(average >= 40 && average <= 49) {
				fortyToFortynine.add(scoresList.get(i));
			}
			if(average >= 50 && average <= 59) {
				fiftyToFiftynine.add(scoresList.get(i));
			}
			if(average >= 60 && average <= 69) {
				sixtyToSixtynine.add(scoresList.get(i));
			}
			if(average >= 70 && average <= 79) {
				seventyToSeventynine.add(scoresList.get(i));
			}
			if(average >= 80 && average <= 89) {
				eightyToEightynine.add(scoresList.get(i));
			}
			if(average >= 90 && average <= 100) {
				ninetyToHundred.add(scoresList.get(i));
			}


		}
		
		double mean1 = mean(zeroToNine);
		double mean2 = mean(tenToNineteen);
		double mean3 = mean(twentyToTwentynine);
		double mean4 = mean(thirtyToThirtynine);
		double mean5 = mean(fortyToFortynine);
		double mean6 = mean(fiftyToFiftynine);
		double mean7 = mean(sixtyToSixtynine);
		double mean8 = mean(seventyToSeventynine);
		double mean9 = mean(eightyToEightynine);
		double mean10 = mean(ninetyToHundred);
		
		
	}
	
	/**
	 * This function is used to add a new error string to the errorMessages arraylist
	 * @param newMessage
	 */
	void addNewError(String newMessage) {
		errorMessages.add(newMessage);
	}
	
	/**
	 * This function prints contents of the error arraylist
	 */
	void printArray() {
		errorMessages.forEach(error -> {;
			System.out.println(error);
		});
	}
	
	
	
	
	
}
