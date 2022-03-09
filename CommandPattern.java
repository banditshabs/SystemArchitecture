public interface Command {
    /**
     * All command objects implement the same interface
     * ,which consists of one method.
     * I only need one method called execute()
     */
    public void execute();
}

/**
 * This is a Command so I need to implement the Command interface
 * 
 */
public class LampOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}

