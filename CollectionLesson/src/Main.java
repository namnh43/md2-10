import animal.Animal;
import animal.Dog;
import arraylist.MyList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyList<Integer> myList = new MyList<>(5);
        for (int i = 0; i < 7; i++) {
            myList.add(i, i * i);
        }
        System.out.println(myList);
        System.out.println(myList.getSize());
        myList.remove(1);
        System.out.println(myList);
        MyList<Integer> cloned = (MyList<Integer>) myList.clone();
        System.out.println(cloned);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println(arrayList);
        ArrayList<Integer> otherList = (ArrayList<Integer>) arrayList.clone();
        System.out.println(otherList.size());

        //
        ArrayList<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal("lion",1));
        animalList.add(new Animal("tiger",2));
//        animalList.add(new Dog("Lina",3));

// Create a collection of Animals or any subclass of Animal
        ArrayList<? extends Animal> animals = animalList;
        animalList.add(new Animal("cat",3));
//        animals.add(new Animal("chicken"));
        for (Animal animal : animals) {
            System.out.println(animal.getName());
        }
        System.out.println(animals);
        System.out.println(animalList);
        animalList.set(1, new Animal("horse",3));

        Animal editAnimal = animalList.get(1);
        System.out.println(editAnimal.hashCode());
//        editAnimal.setName("horse");
        System.out.println(animalList);

        System.out.println(animalList.indexOf(new Animal("cat",3)));
    }

}
