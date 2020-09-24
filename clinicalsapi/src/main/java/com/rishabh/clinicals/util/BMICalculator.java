package com.rishabh.clinicals.util;

import java.util.List;

import com.rishabh.clinicals.models.ClinicalData;

public class BMICalculator {
	
	public static void calculateBMI(List<ClinicalData> clinicalData, ClinicalData eachEntry) {
		
		if(eachEntry.getComponentName().equals("hw")) {
		
			String[] heightandweight=eachEntry.getComponentValue().split("/");
		
			if(heightandweight!=null && heightandweight.length>1) {
				
		      eachEntry.getComponentValue().split("/");
		      float heightinmetres=Float.parseFloat(heightandweight[0]) * 0.4356F;
		      float bmi=Float.parseFloat(heightandweight[1])/(heightinmetres*heightinmetres);
		      ClinicalData bmidata = new ClinicalData();
		      bmidata.setComponentName("bmi");
		      bmidata.setComponentValue(Float.toString(bmi));
		
		      clinicalData.add(bmidata);
			}
		}
	}

}
