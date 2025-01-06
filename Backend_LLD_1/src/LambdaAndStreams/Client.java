package LambdaAndStreams;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {

        //Anonymous Class
        SampleFunctionalInterface sfi1 = new SampleFunctionalInterface() {
            @Override
            public void fun() {
                System.out.println("Hello from an anonymous class!");
            }
        };
        sfi1.fun();
        //Lambda Expression
        SampleFunctionalInterface sfi2 = () -> System.out.println("Hello from a functional interface!");
        sfi2.fun();

        //BiConsumer
        BiConsumer<Integer, Integer> add = (a, b) -> System.out.println("Sum: " + (a + b));
        add.accept(10, 20);

        //Predicate
        Predicate<Integer> isEven = a -> a % 2 == 0;
        System.out.println("Is 10 even? " + isEven.test(10));

        //With functional interface instead of creating a class
        //you can define the method via lambda expression
        Runnable task = () -> {
            System.out.println("Hello from a thread!");
        };
        Thread thread = new Thread(task);
        thread.start();

        List<Integer> list = new ArrayList<>(List.of(31, 22, 13, 46, 5));
        Collections.sort(list, (a, b) -> {
            if (a % 2 == b % 2) {
                return b - a;
            } else if (a % 2 == 0) {
                return -1;
            } else {
                return 1;
            }
        });
        System.out.println("Sorted list: " + list);

        //another way to sort list using Comparator
        Comparator<Integer> com = Comparator.comparingInt(a -> a);
        list.sort(com);
        System.out.println("Another Sorted list: " + list);

        //Streams
        //Create a list of integers and filter odd numbers
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> oddNums = nums.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
        System.out.println("Odd numbers: " + oddNums);

        //Map
        List<Integer> squares = nums.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println("Squares: " + squares);

        //FlatMap Example
        List<List<Integer>> list1 = List.of(List.of(1, 2), List.of(3, 4), List.of(5, 6));
        System.out.println("Original List: " + list1);
        //List<Integer> flatList = list1.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
        //same as above
        List<Integer> flatList = list1.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println("Flat List: " + flatList);
    }
}

