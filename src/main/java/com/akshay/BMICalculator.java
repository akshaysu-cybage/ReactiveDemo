package com.akshay;

import java.util.Scanner;

public class BMICalculator {
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter height in centimeters:");
		double heightInCMs = scanner.nextDouble();
		System.out.println("height in centimeters:" + heightInCMs);
		double heightInMeters = heightInCMs/100;
		System.out.println("height in meters:" + heightInMeters);
		
		System.out.println("please enter Weight in kilograms:");
		double weightInKgs = scanner.nextDouble();
		System.out.println("Weight in kilograms:" + weightInKgs);
		
		double bmi = weightInKgs / Math.pow(heightInMeters, 2);
		System.out.println("BMI is:" + String.format("%.2f", bmi));
		printBmiCategory(bmi);
	}
	
	private static void printBmiCategory(double bmi) {
		if(bmi < 18.5 && bmi > 0) {
			System.out.println("YOUR ARE UNDERWEIGHT");
		}else if(18.5 < bmi && bmi < 25) {
			System.out.println("YOUR ARE NORMAL");
		}else if(25 < bmi && bmi < 30) {
			System.out.println("YOUR ARE OVERWEIGHT");
		}else {
			System.out.println("YOUR ARE OBESE");
		}
	}

}
