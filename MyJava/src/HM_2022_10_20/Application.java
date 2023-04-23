package HM_2022_10_20;

interface Animal{                                       //interface : Animal
    void cry();                                        //sound of animal, override by class
    String getAnimalName();                           //name of animal, override by class
}

class Cat implements Animal{                        //class : Cat
    @Override
    public void cry() {
        System.out.println("Miao Miao Miao");
    }

    @Override
    public String getAnimalName() {
        return "cat";
    }
}

class Dog implements Animal{                    //class : Dog
    @Override
    public void cry() {
        System.out.println("Woof Woof Woof");
    }

    @Override
    public String getAnimalName() {
        return "dog";
    }
}

class Simulator{                                     //class : Simulator
    void playSound(Animal animal){                  //function : To show the sound and name of animal
        System.out.println(animal.getAnimalName()); //reference : variable of interface Animal
        animal.cry();
    }
}

public class Application {
    public  static void main(String[] args){
        Simulator simulator = new Simulator();
        simulator.playSound(new Cat());
        simulator.playSound(new Dog());
    }
}
