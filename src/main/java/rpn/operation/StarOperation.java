package rpn.symbols;

/**
 * Created by yohanfairfort on 21/03/2018.
 */
public class StarOperation implements IOperation
{
    public double Calculate(double leftMember, double rightMember)
    {
        return leftMember * rightMember;
    }
}
