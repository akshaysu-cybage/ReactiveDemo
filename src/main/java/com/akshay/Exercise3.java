package com.akshay;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()
        
    	//Reactive programming has 2 main interfaces
    	//1. flux and 2. mono
    	//flux is 0 or n number of items, mono is 0 or 1 item that we can get asynchronously
    	//flux has concept of backPressure where if publisher is publishing too fast for a subscriber then subscriber can ask publisher to slow down
    	
    	// Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
    	//so here if we want to convert it to list then it becomes a blocking operation
        List<Integer> numbers =  ReactiveSources.intNumbersFlux().toStream().collect(Collectors.toList()); //java8
        List<Integer> numbers2 =  ReactiveSources.intNumbersFlux().toStream().toList(); //java 17
        System.out.println("List :" + numbers2);
        System.out.println("Length :" + numbers2.size());

        System.out.println("Press a key to end");
        System.in.read();
    }

}
