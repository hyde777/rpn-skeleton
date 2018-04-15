package rpn;

import java.util.ArrayList;

/**
 * Created by yohanfairfort on 15/04/2018.
 */
public interface ITokeniser {
    ArrayList<String> getTokens(String rawString);
}
