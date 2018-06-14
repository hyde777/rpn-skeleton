package rpn.events;

public interface OnEvent<T extends IEvent> {
    void onEvent(T event);
    Class getEventType();
}
