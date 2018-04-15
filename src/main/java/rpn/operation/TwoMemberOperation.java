package rpn.operation;

import java.util.ArrayList;

/**
 * Created by yohanfairfort on 15/04/2018.
 */
public abstract class TwoMemberOperation implements IOperation{
    abstract double Calculate(double left, double right);

    public void Operate(ArrayList<String> calculMembers, int i)
    {
        double leftMember = Double.parseDouble(calculMembers.get(i - 2));
        double rightMember = Double.parseDouble(calculMembers.get(i - 1));
        calculMembers.set(i - 1, Double.toString(Calculate(leftMember, rightMember)));
        calculMembers.remove(i);
        calculMembers.remove(i - 2);
    }
}
