package com.capgemini.dtc.app.sample;

public class SampleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] x = "ThisIsMyString".split("(?=[A-Z])");
		String res = "";
		for(int i =0; i< x.length;i++){
			
			if(i == x.length-1){
				res += x[i];
			}else{
				res += x[i] + " ";
			}
		}
		System.out.println(res);

	}

}
