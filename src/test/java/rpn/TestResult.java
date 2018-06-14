package rpn;

import rpn.events.OnEvent;
import rpn.events.ResultEvent;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class TestResult implements OnEvent<ResultEvent> {
    private int expectedResult;
    public TestResult(int expectedResult)
    {
        this.expectedResult = expectedResult;
    }

    @Override
    public void onEvent(ResultEvent resultEvent) {
        Double result = Double.parseDouble(resultEvent.getResult());
        assertThat(expectedResult).isEqualTo(result);
    }

    @Override
    public Class getEventType() {
        return ResultEvent.class;
    }
}
