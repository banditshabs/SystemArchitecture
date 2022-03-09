// The command Design Pattern
// Design a simple remote control with 2 buttons - on/open and off/close
// , that operates with as of yet unkown 3rd party imnplentations
class Light {
    String _name;
    //This method names each of the light objects e.g. "Bedroom light"
    public Light(String name) {
        _name = name;
    }

    public void switchOn() {
        System.out.println(_name + "light is on");
    }

    public void switchOff() {
        System.out.println(_name + "light is off");
    }
}

class GarageDoor {
    public GarageDoor() {}

    public void open() {
        System.out.println("Garage Door is opening");
    }

    public void close() {
        System.out.println("Garage Door is closing");
    }
}

//************************/

// Remote control that invokes 3rd party implementations,
// that are not known at development time.
class SimpleRemoteControl{
    Command command;

    public SimpleRemoteControl() {}

    public void setCommand(Command command){
        this.command = command;
    }

    public void buttonPressed() {
        command.execute();
    }
}

// Commands
interface Command {
    void execute();
}

// Open the garage door
class GarageDoorOpenCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    public void execute() {
        garageDoor.open();
    }
}

// Close the garage door
class GarageDoorCloseCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorCloseCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    public void execute() {
        garageDoor.close();
    }
}

// Turn On the light
class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.switchOn();
    }
}

// Turn Off the light
class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.switchOff();
    }
}

public class CommandRemote {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();

        Light kitchenLight = new Light("Kitchen");
        GarageDoor garageDoor = new GarageDoor();

        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor);
            
        GarageDoorCloseCommand garageClose = new GarageDoorCloseCommand(garageDoor);


        remote.setCommand(kitchenLightOn);
        remote.buttonPressed();
        remote.setCommand(kitchenLightOff);
        remote.buttonPressed();

        remote.setCommand(garageOpen);
        remote.buttonPressed();

        remote.setCommand(garageClose);
        remote.buttonPressed();
            
    }
}