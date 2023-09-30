package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberFlux() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumbersFluxWithException().subscribe(
                n -> System.out.println("num: " + n),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("flux completed")
        );

        ReactiveSources.userMono().subscribe(
                user -> System.out.println(user),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("mono completed")
        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux()
                .subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {

    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("subscribe happened");
        request(1);
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.print(value.toString() + "received, ");
        System.out.println(Thread.currentThread());
        request(1);
    }


}