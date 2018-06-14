package rpn;

import rpn.events.*;

import java.util.ArrayList;

import static java.util.Arrays.asList;

/**
 * Created by yohanfairfort on 15/04/2018.
 */
public class SingleSpaceTokeniser implements OnEvent<InputEvent> {

    private EventDispatcher dispatcher;

    public SingleSpaceTokeniser(EventDispatcher dispatcher)
    {
        this.dispatcher = dispatcher;
    }

    private ArrayList<String> getTokens(String rawString) {
        return new ArrayList(asList(rawString.split(" ")));
    }

    @Override
    public void onEvent(InputEvent inputEvent) {
        SendTokenEvent sendTokenEvent = new SendTokenEvent(getTokens(inputEvent.getInput()));
        dispatcher.dispatch(sendTokenEvent);
    }

    @Override
    public Class getEventType() {
        return InputEvent.class;
    }
}
