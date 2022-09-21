package com.akshay;

import java.io.IOException;

import reactor.core.publisher.Flux;

public class Exercise8 {
	
	//Error handling
	//1. error is a terminal event
	//2. original sequence does not continue
	//3. calls the 'onError' method on the Subscriber
	
	
	public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        ReactiveSources.intNumbersFluxWithException()
        		.subscribe(System.out::println,
        				error -> System.out.println("Error occurred..."));
        
        ReactiveSources.intNumbersFluxWithException()
        		.doOnError(error -> System.out.println("Error occurred..."))
        		.subscribe(System.out::println);			//here it will still go and print the stack trace

        // Print values from intNumbersFluxWithException and continue on errors
        ReactiveSources.intNumbersFluxWithException()
        		.onErrorContinue((error, item) -> System.out.println("Error occurred... but will continue .." + error.getMessage()))
        		.log()
        		.subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        ReactiveSources.intNumbersFluxWithException()
				.onErrorResume(error -> Flux.just(-1,-2))
				.subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }
}
