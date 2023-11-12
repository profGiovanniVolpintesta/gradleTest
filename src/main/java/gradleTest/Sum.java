package gradleTest;

import java.util.Scanner;

public class Sum
{
    public static void main(final String[] args)
    {
        Scanner sc = new Scanner (System.in);

        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());

        int c = a * b;
        // int c = a + b;

        System.out.println("Il risultato è: " + c);

        // int d = Integer.parseInt(sc.nextLine());
    }
}
