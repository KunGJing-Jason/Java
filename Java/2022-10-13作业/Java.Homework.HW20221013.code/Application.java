package Homework.HW20221013;

public class Application {
    public static void main(String[] args){
        Simulator simulator = new Simulator();      //instance of Simulator Class;

        simulator.playSound(new Dog());             //Call function : void playSound(Animal animal);
        simulator.playSound(new Cat());             //reference : The subclass of Animal, Cat and Dog;
    }
}
