package rpn;

import rpn.events.EventDispatcher;
import rpn.events.OnEvent;
import rpn.events.OperationEvent;
import rpn.events.SendTokenEvent;
import rpn.operation.IOperation;

import java.util.List;
import java.util.Map;

public class Orchestrator implements OnEvent<OperationEvent> {
    private Map<String, IOperation> symbols;
    private EventDispatcher dispatcher;

    public Orchestrator(EventDispatcher dispatcher, Map<String, IOperation> symbols) {
        this.dispatcher = dispatcher;
        this.symbols = symbols;
    }

    @Override
    public void onEvent(OperationEvent operationEvent) {
        List<String> calculMembers = operationEvent.getCalculMember();

        for (int i = 0; calculMembers.size() != 1; i++) {
            if (!symbols.keySet().contains(calculMembers.get(i)))
                continue;

            symbols.get(calculMembers.get(i)).Operate(calculMembers, i);
            dispatcher.dispatch(new SendTokenEvent(calculMembers));
            return;
        }
    }

    @Override
    public Class<OperationEvent> getEventType() {
        return OperationEvent.class;
    }
}
