package Homework.HW20221013;

public class Dog extends Animal{
    @Override
    void cry() {
        System.out.println("Woof Woof Woof...");    //Override the function in abstract Parent Class : Animal
    }
    String getAnimalName(){
        System.out.println("Dog");                  //Override the function in abstract Parent Class : Animal
        return "Dog";
    }
}
