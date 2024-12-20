package GenericsCollection.Bound;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.setName("animal");
        Mammal mammal = new Mammal();
        mammal.setName("Mammal");
        Cat cat = new Cat();
        cat.setName("Cat");
        Dog dog = new Dog();
        dog.setName("Mammal");

        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        animals.add(mammal);
        animals.add(dog);
        animals.add(cat);

        AnimalUtility.printAnimalName(animals);
        List<Dog> dogs = new ArrayList<>();
        //We can't pass List<Dog> as param because it only allows List<Animal> to be pass as param.
        // To pass same we can use below method
        //AnimalUtility.printAnimalName(dogs); //CTE
        AnimalUtility.printAnimalUsingType(animals);
        AnimalUtility.printAnimalUsingType(dogs);

        AnimalUtility.printAnimalUsingExtends(animals);
        AnimalUtility.printAnimalUsingExtends(dogs);
    }
}
