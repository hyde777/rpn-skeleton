package rpn;

import rpn.ITokeniser;

import java.util.ArrayList;

import static java.util.Arrays.asList;

/**
 * Created by yohanfairfort on 15/04/2018.
 */
public class SingleSpaceTokeniser implements ITokeniser {

    public ArrayList<String> getTokens(String rawString) {
        return new ArrayList(asList(rawString.split(" ")));
    }
}
