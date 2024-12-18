package Generics.Bound;

import java.util.List;

public class AnimalUtility {
    public static void printAnimalName(List<Animal> animals){
        for(Animal animal:animals){
            System.out.println(animal.getName());
        }
    }

    //Here we can pass List of any type T which extends Animal
    public static <T extends Animal> void printAnimalUsingType(List<T> animals){
        for(T animal:animals){
            System.out.println(animal.getName());
        }
    }
    //wild card (?)
    //we can use it when there is no specific use of type (T) inside method
    //Here we can pass List of any type T which extends Animal
    public static void printAnimalUsingExtends(List<? extends Animal> animals){
        for(Animal animal:animals){
            System.out.println(animal.getName());
        }
    }

    //Here we can pass List<Animal>, List<Mammal> in param
    public void addDogs(List<? super Dog> temp){
        temp.add(new Dog());
    }
}
