package com.akshay;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()
    	//
        // Print all numbers in the ReactiveSources.intNumbersFlux stream
    	//flux is a stream of elements over a period of time 
    	//here in the reactive programming,  foreach is replaced by subscribe and here this flux method will decide when to send the data,
    	//but whenever the data comes, the things we need to do for each flux element is written in this subscribe method
        ReactiveSources.intNumbersFlux().subscribe(number -> {System.out.println(number + " ");});
        System.out.println("\n*********************");
        // Print all users in the ReactiveSources.userFlux stream
        ReactiveSources.userFlux().subscribe(user -> {System.out.println(user + " ");});
        
        
        //if we dont write this system.in then code will end even before we get anything as input from the streams
        System.out.println("Press a key to end");
        System.in.read();
    }

}