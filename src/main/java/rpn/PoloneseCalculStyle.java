package rpn;

import rpn.events.*;

import java.util.List;

/**
 * Created by yohanfairfort on 21/03/2018.
 */
public class PoloneseCalculStyle implements OnEvent<SendTokenEvent>
{
    EventDispatcher dispatcher;

    public PoloneseCalculStyle(EventDispatcher dispatcher)
    {
        this.dispatcher = dispatcher;
    }

    private void Calculate(List<String> calculMembers)
    {
        if(calculMembers.size() > 1)
            dispatcher.dispatch(new OperationEvent(calculMembers));
        else
            dispatcher.dispatch(new ResultEvent(calculMembers.get(0)));
    }

    @Override
    public void onEvent(SendTokenEvent sendTokenEvent) {
        Calculate(sendTokenEvent.getTokens());
    }

    @Override
    public Class getEventType() {
        return SendTokenEvent.class;
    }
}
