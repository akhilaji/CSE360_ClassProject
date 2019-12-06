package classProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class GraphClass {
	
	final static String zero = "0% - 9%";
	final static String ten = "10% - 19%";
	final static String twenty = "20% - 29%";
	final static String thirty = "30% - 39%";
	final static String forty = "40% - 49%";
	final static String fifty = "50% - 59%";
	final static String sixty = "60% - 69%";
	final static String seventy = "70% - 79%";
	final static String eighty = "80% - 89%";
	final static String ninty = "90% - 100%";
	
	public GraphClass(){}
	
	public Scene barGraph(int[] data){
		
		int dataSet[] = data;
	
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
        xAxis.setLabel("Data Sets");       
        yAxis.setLabel("Percentage");
        
        XYChart.Series series1 = new XYChart.Series();      
        series1.getData().add(new XYChart.Data(zero, dataSet[0]));
        series1.getData().add(new XYChart.Data(ten, dataSet[1]));
        series1.getData().add(new XYChart.Data(twenty, dataSet[2]));
        series1.getData().add(new XYChart.Data(thirty, dataSet[3]));
        series1.getData().add(new XYChart.Data(forty, dataSet[4]));
        series1.getData().add(new XYChart.Data(fifty, dataSet[5]));
        series1.getData().add(new XYChart.Data(sixty, dataSet[6]));
        series1.getData().add(new XYChart.Data(seventy, dataSet[7]));
        series1.getData().add(new XYChart.Data(eighty, dataSet[8]));
        series1.getData().add(new XYChart.Data(ninty, dataSet[9]));
        
        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1);
        return scene;
    }
	
}
