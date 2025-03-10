package io.javabrains.reactiveworkshop;

import java.util.Set;
import java.util.stream.Collectors;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(System.out::println);
        System.out.println();

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(n -> n < 5).forEach(System.out::println);
        System.out.println();

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream()
                .filter(n -> n > 5)
                .skip(1).limit(2).forEach(System.out::println);
        System.out.println();

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        Integer value = StreamSources.intNumbersStream().filter(n -> n > 5).findFirst().orElse(-1);
        System.out.println(value);
        System.out.println();


        // Print first names of all users in userStream
        StreamSources.userStream().map(User::getFirstName).forEach(System.out::println);
        System.out.println();

        // Print first names in userStream for users that have IDs from number stream
        Set<Integer> ids = StreamSources.intNumbersStream().collect(Collectors.toSet());
        StreamSources.userStream().filter(user -> ids.contains(user.getId()))
                .map(User::getFirstName).forEach(System.out::println);
        System.out.println();

        // another solution
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(User::getFirstName).forEach(System.out::println);
        System.out.println();

        //yet another solution
        StreamSources.userStream()
                .filter(u -> StreamSources.intNumbersStream().anyMatch(i -> u.getId() == i))
                .map(User::getFirstName)
                .forEach(System.out::println);
    }

}
