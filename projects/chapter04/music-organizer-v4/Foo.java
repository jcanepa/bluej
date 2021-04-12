public class Foo
{

    public Foo()
    {
        //
    }
    
    /**
     * Print the multiples of five between ten and ninety-five.
     */
    public void multiplesOfFive()
    {
        int index = 10;
        int max = 95;

        while (index <= 95) {
            System.out.println(index);
            index += 5;
        }
    }
    
    /**
     * Add up the values between 0 and ten.
     */
    public void exercise_4_31()
    {
        int index = 0;
        int sum = 0;
        
        while (index < 10) {
            index++;
            sum += index;
        }
        System.out.println(sum);
    }
    
    /**
     * Sum the numbers between two integers.
     */
    public void sum(int a, int b)
    {
        int index = a + 1;
        int sum = 0;
        
        while (index < b) {
            sum += index;
            index++;
        }
        System.out.println(sum);
    }
    
    /**
     * Deturmine if a given integer is a prime number.
     */
    public boolean isPrime(int n)
    {
        int divisor = 2;
        boolean foundFactor = false;
        
        while (!foundFactor && divisor < n) {
            if (n % divisor == 0) {
                foundFactor = true;
            }
            divisor++;
        }
        return !foundFactor;
    }
    
    public String switchExample(int month)
    {
        String quarter = "";
        
        switch (month) {
            case 1:
            case 2:
            case 3:
                quarter = "Q1";
                break;
            case 4:
            case 5:
            case 6:
                quarter = "Q2";
                break;
            case 7:
            case 8:
            case 9:
                quarter = "Q3";
                break;
            case 10:
            case 11:
            case 12:
                quarter = "Q4";
                break;
        }
        return quarter;
    }
}      
