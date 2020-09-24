package com.bharath.location.util;

import java.io.IOException;
import java.util.List;

import java.io.File;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ReportUtilImpl implements ReportUtil {
	
    @SuppressWarnings("deprecation")
	public void generatePieChart(String path, List<Object[]> data) {
    	
    	
		DefaultPieDataset dataset=new DefaultPieDataset();
		
		for(Object[] objects:data) {
			
			dataset.setValue(objects[0].toString(), new Double(objects[1].toString()));
		}
		
		JFreeChart chart = ChartFactory.createPieChart3D("Location Type Report",dataset, false, false, false);
		
		
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/pieChart.jpeg"), chart, 300, 300);
		
			
		}
		catch(IOException e){
			e.printStackTrace();
			
		}
	}
}
