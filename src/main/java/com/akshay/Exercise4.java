package com.akshay;

import java.io.IOException;

public class Exercise4 {
	
	public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(number -> System.out.println(number + "\n"));
        ReactiveSources.intNumberMono()
        		.subscribe(
        				number -> System.out.println(number + "\n"),
        				error -> System.out.println(error.getMessage() + " print this for failure Event\n"),
        				() -> System.out.println(" print this on completion Event")
        				);

        // Get the value from the Mono into an integer variable
        //we can use block or blockoptional method for this
        Integer number = ReactiveSources.intNumberMono().block();
        Integer number2= ReactiveSources.intNumberMono().blockOptional().get();
        System.out.println("number is:" +number2);
        
        User user = ReactiveSources.userMono().block();

        System.out.println("Press a key to end");
        System.in.read();
    }

}
