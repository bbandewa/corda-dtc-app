package com.capgemini.dtc.app.util;

public class StringUtil {
	
	public static String splitByUpperCase(String input){
		String[] x = input.split("(?=[A-Z])");
		String res = "";
		for(int i =0; i< x.length;i++){
			
			if(i == x.length-1){
				res += x[i];
			}else{
				res += x[i] + " ";
			}
		}
		return res;
	}

}
