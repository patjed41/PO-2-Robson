public class przyklad
{
    public static void main(String[] args)
    {
        // deklaracje zmiennych, które w Robsonie są globalne
        double temp = 0;
        double numer = 0;
        double x1 = 0;
        double index = 0;
        double x2 = 0;

        {
            numer = 10.0;
            if ((numer <= 2.0))
            {
                1.0;
            }
            else
            {
                x1 = 1.0;
                x2 = 1.0;
                index = 3.0;
                while ((index <= numer))
                {
                    temp = (x1 + x2);
                    x1 = x2;
                    x2 = temp;
                    index = (index + 1.0);
                }
                x2;
            }
        }
    }
}