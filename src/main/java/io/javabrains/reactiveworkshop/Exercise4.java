package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.time.Duration;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(n -> System.out.println(n));

        // Get the value from the Mono into an integer variable
        Integer number = ReactiveSources.intNumberMono().block(Duration.ofSeconds(3));
        System.out.println("Number stored in variable: " + number);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
