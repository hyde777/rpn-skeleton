package rpn.events;

import java.util.List;

public class OperationEvent implements IEvent {
    private List<String> calculMember;

    public OperationEvent(List<String> calculMember)
    {
        this.calculMember = calculMember;
    }

    public List<String> getCalculMember() {
        return calculMember;
    }
}
