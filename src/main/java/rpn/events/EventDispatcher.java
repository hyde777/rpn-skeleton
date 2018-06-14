package rpn.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventDispatcher {
    Map<Class, List<OnEvent>> listeners;

    public EventDispatcher()
    {
        listeners = new HashMap<>();
    }

    public void registerChannel(OnEvent listener) {
        if(!listeners.containsKey(listener.getEventType()))
            listeners.put(listener.getEventType(), new ArrayList<>());

        List<OnEvent> tmp = listeners.get(listener.getEventType());
        tmp.add(listener);
        listeners.replace(listener.getEventType(), tmp);
    }

    public void dispatch(IEvent event) {
        listeners.get(event.getClass()).forEach(listener -> listener.onEvent(event));
    }
}
