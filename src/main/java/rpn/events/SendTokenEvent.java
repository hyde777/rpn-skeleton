package rpn.events;

import java.util.List;

public class SendTokenEvent implements IEvent {
    private List<String> tokens;

    public SendTokenEvent(List<String> tokens){
        this.tokens = tokens;
    }

    public List<String> getTokens() {
        return tokens;
    }
}
