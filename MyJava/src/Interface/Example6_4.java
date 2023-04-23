package Interface;

abstract class MotorVehicles{
    abstract void brake();
}

interface MoneyFare{
    void charge();
}

interface ControlTemperature{
    void contorlAirtemperature();
}

class Bus extends MotorVehicles implements MoneyFare{
    void brake(){
        System.out.println("Buses use the brake");
    }

    @Override
    public void charge() {
        System.out.println("Buses: $1 / ticket, not counting the miles");
    }
}

public class Example6_4 {
}
