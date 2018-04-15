package rpn.operation;

/**
 * Created by yohanfairfort on 21/03/2018.
 */
public class MinusOperation extends TwoMemberOperation
{
    public double Calculate(double leftMember, double rightMember)
    {
        return leftMember - rightMember;
    }
}
