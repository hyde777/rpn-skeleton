package rpn.events;

public class InputEvent implements IEvent {

    private String input;

    public String getInput(){
        return input;
    }

    public InputEvent(String expression)
    {
        this.input = expression;
    }
}
