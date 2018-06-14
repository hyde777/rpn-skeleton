package rpn;

import rpn.events.OnEvent;
import rpn.events.ResultEvent;

public class WriteConsole implements OnEvent<ResultEvent> {
    @Override
    public void onEvent(ResultEvent resultEvent) {
        System.out.println("> " + resultEvent.getResult());
    }

    @Override
    public Class getEventType() {
        return ResultEvent.class;
    }
}
