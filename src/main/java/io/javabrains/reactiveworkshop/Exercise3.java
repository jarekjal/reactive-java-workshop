package io.javabrains.reactiveworkshop;

import java.util.List;

public class Exercise3 {

    public static void main(String[] args) {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        System.out.println("Waiting for Flux to emit all elements...");
        List<Integer> numbers = ReactiveSources.intNumbersFlux().toStream().toList();
        System.out.println("numbers: " + numbers);
        System.out.println("size: " + numbers.size());

//        System.out.println("Press a key to end");
//        System.in.read();
    }

}
