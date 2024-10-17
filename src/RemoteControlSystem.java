// RemoteControlSystem.java

// Device Interface
interface Device {
    void powerOn();
    void powerOff();
    void setChannel(int channel);
    void setVolume(int volume);
}

// Concrete Device: TV
class TVDevice implements Device {
    @Override
    public void powerOn() {
        System.out.println("TV is now ON.");
    }

    @Override
    public void powerOff() {
        System.out.println("TV is now OFF.");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("TV channel set to " + channel);
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("TV volume set to " + volume);
    }
}

// Concrete Device: DVD Player
class DVDDevice implements Device {
    @Override
    public void powerOn() {
        System.out.println("DVD Player is now ON.");
    }

    @Override
    public void powerOff() {
        System.out.println("DVD Player is now OFF.");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("DVD Player doesn't support channels.");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("DVD Player volume set to " + volume);
    }
}

// Concrete Device: Sound System
class SoundSystemDevice implements Device {
    @Override
    public void powerOn() {
        System.out.println("Sound System is now ON.");
    }

    @Override
    public void powerOff() {
        System.out.println("Sound System is now OFF.");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("Sound System doesn't support channels.");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("Sound System volume set to " + volume);
    }
}

// Abstract RemoteControl class
abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void powerOn() {
        device.powerOn();
    }

    public void powerOff() {
        device.powerOff();
    }

    public void setChannel(int channel) {
        device.setChannel(channel);
    }

    public void setVolume(int volume) {
        device.setVolume(volume);
    }
}

// Concrete Remote: BasicRemote with Mute Functionality
class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("Muting the device.");
        device.setVolume(0);
    }
}

// Concrete Remote: AdvancedRemote with Sleep Timer
class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void setSleepTimer(int minutes) {
        System.out.println("Setting sleep timer for " + minutes + " minutes.");
    }
}

// Main Class to Demonstrate the Bridge Pattern
public class RemoteControlSystem {
    public static void main(String[] args) {
        Device tv = new TVDevice();
        Device dvd = new DVDDevice();
        Device soundSystem = new SoundSystemDevice();

        // Using Basic Remote for TV
        BasicRemote tvRemote = new BasicRemote(tv);
        tvRemote.powerOn();
        tvRemote.setChannel(5);
        tvRemote.setVolume(15);
        tvRemote.mute();
        tvRemote.powerOff();

        System.out.println();

        // Using Advanced Remote for DVD Player
        AdvancedRemote dvdRemote = new AdvancedRemote(dvd);
        dvdRemote.powerOn();
        dvdRemote.setVolume(20);
        dvdRemote.setSleepTimer(30);
        dvdRemote.powerOff();

        System.out.println();

        // Using Basic Remote for Sound System
        BasicRemote soundRemote = new BasicRemote(soundSystem);
        soundRemote.powerOn();
        soundRemote.setVolume(50);
        soundRemote.mute();
        soundRemote.powerOff();
    }
}
