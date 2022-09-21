package com.akshay;

import java.io.IOException;

import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

    	//Completion and Failure event are terminal events, nothing happens after them.
    	//A flux or mono will send either of the two in case of sucess and failure for Completion and Failure resp.
    	
        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumbersFlux()
        		.subscribe(number -> System.out.println(number +""), 
        				error -> System.out.println("print this on error/failure Event"), 
        				() -> System.out.println("print this on numbers completion event"));
        
        ReactiveSources.userFlux()
		.subscribe(user -> System.out.println(user +""), 
				error -> System.out.println("print this on error/failure Event"), 
				() -> System.out.println("print this on user completion event"));

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux()
			.subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }
    
}

class MySubscriber<T> extends BaseSubscriber<T>{
	
	@Override
	public void hookOnSubscribe(Subscription subscription) {
		System.out.println("subscribe happened");
		request(1);
	}
	
	@Override
	public void hookOnNext(T value) {
		System.out.println(value +" received");
		request(1);
	}
}
