package rpn.operation;

/**
 * Created by yohanfairfort on 21/03/2018.
 */
public class SlashOperation extends TwoMemberOperation
{
    public double Calculate(double leftMember, double rightMember)
    {
        if(rightMember == 0)
            throw new ArithmeticException();
        return leftMember / rightMember;
    }
}
