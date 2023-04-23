package Homework.HW20221013;

public class Cat extends Animal{
    void cry() {
        System.out.println("Miao Miao Miao...");    //Override the function in abstract Parent Class : Animal
    }
    String getAnimalName(){
        System.out.println("Cat");                  //Override the function in abstract Parent Class : Animal
        return "Cat";
    }
}
