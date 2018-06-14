package rpn.events;

public class ResultEvent implements IEvent {
    private String result;

    public ResultEvent(String result) {
        this.result = result;
    }

    public String getResult()
    {
        return result;
    }
}
