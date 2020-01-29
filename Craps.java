
/**
 * Plays the classic game of craps!
 *
 * @author Dylan Boyer
 * @version 2020-1-17
 */

import java.util.Scanner;

public class Craps
{
    public static void giveInstructions(Scanner in)
    {
        System.out.println("Would you like instructions on how to play Craps (Y/n)?");
        String play = in.nextLine();
        if (play.equals("") || play.substring(0, 1).equalsIgnoreCase("y"))
        {
            System.out.println("1. A player rolls two six-sided dice and adds the numbers rolled together.");
            System.out.println("2. On this first roll, a 7 or an 11 automatically wins, and a 2, 3, or 12 automatically" + "\n" + 
                "loses,and play is over. If a 4, 5, 6, 8, 9, or 10 are rolled on this first roll, that number becomes the point.");
            System.out.println("3. The player continues to roll the two dice again until one of two things happens: either they roll the" + "\n" +
                "point from that first roll again, in which case they win; or they roll a 7, in which case they lose.");
        }
    }

    public static void main(String[] args)
    {
        System.out.println("The Game of Craps...");
        Scanner in = new Scanner(System.in);
        giveInstructions(in);
        System.out.print("\n");
        System.out.println("Let's play the Game of Craps!");
        String play = "y";
        while (play.equals("") || play.equals("y"))
        {
            int point = 0;
            String start = "Press [Enter] to play the game!";
            System.out.println(start);
            in.nextLine();
            Die d1 = new Die();
            Die d2 = new Die();
            int result1 = d1.roll();
            int result2 = d2.roll();
            int roll1 = result1 + result2;
            System.out.println("You rolled a " + result1 + " and a " + result2 + ". Your total is " + roll1 + ".");
            if (roll1 == 7 || roll1 == 11)
            {
                System.out.println("You win!");
                
            }
            else if (roll1 == 2 || roll1 == 3 || roll1 == 12)
            {
                System.out.println("You lose!");
                
            }
            else
            {
                point = roll1;
                System.out.println("The point is " + point + ".");
                System.out.println("Press [Enter] to roll.");
                in.nextLine();
                int result3 = d1.roll();
                int result4 = d2.roll();
                int roll2 = result3 + result4;
                System.out.println("You rolled a " + result3 + " and a " + result4 + ". Your total is " + roll2 + " and the point is " + point + ".");
                while (true)
                {
                    System.out.println("Press [Enter] to roll.");
                    in.nextLine();
                    result3 = d1.roll();
                    result4 = d2.roll();
                    roll2 = result3 + result4;
                    System.out.println("You rolled a " + result3 + " and a " + result4 + ". Your total is " + roll2 + " and the point is " + point + ".");
                    if (roll2 == point)
                    {
                       System.out.println("You win!"); 
                       break;
                    }
                    else if (roll2 == 7)
                    {
                        System.out.println("You lose!");
                        break;
                    }
                }
            }
            System.out.println("\n");
            System.out.println("Do you want to play again (Y/n)?");
            play = in.nextLine();
        }
        System.out.println("\n");
        System.out.println("Goodbye, thanks for playing!");
    }
}