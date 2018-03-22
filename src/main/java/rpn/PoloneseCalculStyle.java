package rpn;

import rpn.operation.IOperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;

import static java.util.Arrays.asList;

/**
 * Created by yohanfairfort on 21/03/2018.
 */
public class PoloneseCalculStyle implements ICalculStyle
{
    private Dictionary<String, IOperation> _symbols;

    public PoloneseCalculStyle(Dictionary<String, IOperation> symbols)
    {
        _symbols = symbols;
    }

    public double Calculate(String rawCalcul)
    {
        ArrayList<String> calculMembers = new ArrayList(asList(rawCalcul.split(" ")));

        for (int i = 0; calculMembers.size() != 1; i++)
        {
            if(!Collections.list(_symbols.keys()).contains(calculMembers.get(i)))
                continue;
            double leftMember = Double.parseDouble(calculMembers.get(i - 2));
            double rightMember = Double.parseDouble(calculMembers.get(i - 1));
            String symbol =  calculMembers.get(i);
            double result = BasicOperation(leftMember, rightMember, symbol);
            ResolveOneStep(calculMembers, i, result);

            i = 0;
        }

        return Double.parseDouble(calculMembers.get(0));
    }

    private void ResolveOneStep(ArrayList<String> calculMembers, int i, double result) {
        calculMembers.set(i - 1, Double.toString(result));
        calculMembers.remove(i);
        calculMembers.remove(i - 2);
    }


    public double BasicOperation(double leftMember, double rightMember, String symbol)
    {
        return _symbols.get(symbol).Calculate(leftMember, rightMember);
    }
}
