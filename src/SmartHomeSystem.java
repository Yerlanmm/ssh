// SmartHomeSystem.java

// 1. Smart Devices with their respective operations
class Light {
    public void turnOn() {
        System.out.println("Lights are ON.");
    }

    public void turnOff() {
        System.out.println("Lights are OFF.");
    }
}

class Thermostat {
    public void setTemperature(int temperature) {
        System.out.println("Thermostat set to " + temperature + " degrees.");
    }
}

class SecuritySystem {
    public void arm() {
        System.out.println("Security system is ARMED.");
    }

    public void disarm() {
        System.out.println("Security system is DISARMED.");
    }
}

class EntertainmentSystem {
    public void playMovie() {
        System.out.println("Playing movie on the entertainment system.");
    }

    public void stopMovie() {
        System.out.println("Stopped the movie.");
    }
}

// 2. SmartHomeFacade Class
class SmartHomeFacade {
    private Light light;
    private Thermostat thermostat;
    private SecuritySystem securitySystem;
    private EntertainmentSystem entertainmentSystem;

    public SmartHomeFacade() {
        light = new Light();
        thermostat = new Thermostat();
        securitySystem = new SecuritySystem();
        entertainmentSystem = new EntertainmentSystem();
    }

    // Methods for different modes
    public void leaveHome() {
        System.out.println("Leaving home...");
        light.turnOff();
        thermostat.setTemperature(18);
        securitySystem.arm();
    }

    public void arriveHome() {
        System.out.println("Arriving home...");
        light.turnOn();
        thermostat.setTemperature(22);
        securitySystem.disarm();
    }

    public void nightMode() {
        System.out.println("Night mode activated...");
        light.turnOff();
        thermostat.setTemperature(20);
        securitySystem.arm();
    }

    public void movieMode() {
        System.out.println("Movie mode activated...");
        light.turnOff();
        thermostat.setTemperature(23);
        entertainmentSystem.playMovie();
    }
}

// 3. SmartHomeApp Class: Demonstrates the Facade Pattern
public class SmartHomeSystem {
    public static void main(String[] args) {
        // Create the facade
        SmartHomeFacade smartHome = new SmartHomeFacade();

        // Demonstrate various modes
        smartHome.arriveHome();
        System.out.println();

        smartHome.movieMode();
        System.out.println();

        smartHome.nightMode();
        System.out.println();

        smartHome.leaveHome();
    }
}
