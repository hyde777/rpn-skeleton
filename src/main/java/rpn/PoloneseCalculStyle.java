package rpn;

import rpn.operation.IOperation;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by yohanfairfort on 21/03/2018.
 */
public class PoloneseCalculStyle implements ICalculStyle
{
    private Map<String, IOperation> symbols;
    private ITokeniser tokeniser;

    public PoloneseCalculStyle(Map<String, IOperation> symbols, ITokeniser tokeniser)
    {
        this.symbols = symbols;
        this.tokeniser = tokeniser;
    }

    public double Calculate(String rawCalcul)
    {
        ArrayList<String> calculMembers = tokeniser.getTokens(rawCalcul);

        for (int i = 0; calculMembers.size() != 1; i++)
        {
            if(!symbols.keySet().contains(calculMembers.get(i)))
                continue;

            symbols.get(calculMembers.get(i)).Operate(calculMembers, i);
            i = 0;
        }

        return Double.parseDouble(calculMembers.get(0));
    }
}
