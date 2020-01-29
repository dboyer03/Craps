
/**
 * Rolls 2 6-sided die and prints them out!
 *
 * @author Dylan Boyer
 * @version 2020-1-16
 */
public class Die
{
    private int roll;
    
    public int roll()
    {
        roll = ((int) (Math.random() * 6) + 1);
        return roll;
    }
    public int getResult()
    {
        return roll;
    }
}


