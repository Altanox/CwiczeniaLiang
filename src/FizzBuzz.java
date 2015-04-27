/**
 * Created by £ukasz Rutkowski on 2015-04-27.
 */
public class FizzBuzz
{
    public static void main(String[] args)
    {
        int i = 1;
        while (i < 100)
        {
            if (i % 3 == 0)
            {
                System.out.println("Fizz");
                i++;
            }
            else if (i % 5 == 0)
            {
                System.out.println("Buzz");
                i++;
            }
            else
            {
                System.out.println(i);
                i++;
            }
        }
    }

}
