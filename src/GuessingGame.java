import java.util.ArrayList;
import java.util.Scanner;

public class GuessingGame
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> allScores = new ArrayList<Integer>();

        System.out.println("Guessing Game");
        System.out.println();
        System.out.println("1. Beginner Level (numbers between 1 and 10)");
        System.out.println("2. Intermediate Level (numbers between 1 and 100)");
        System.out.println("3. Advanced Level (numbers between 1 and 1,000)");
        System.out.println("4. Expert Level (numbers between 1 and 10,000)");
        System.out.println();
        System.out.print("Please type the number corresponding to the difficulty you wish to play: ");

        String chosenLevel = input.nextLine();
        System.out.println();

        runGame(chosenLevel, input, allScores);
    }

    public static void runGame(String chosenLevel, Scanner input, ArrayList<Integer> allScores)
    {
        while(chosenLevel.equals(""))
        {
            System.out.print("Please provide a number between 1 and 4: ");
            chosenLevel = input.nextLine();
        }

        while (!chosenLevel.equals("1") && !chosenLevel.equals("2") && !chosenLevel.equals("3") && !chosenLevel.equals("4"))
        {
            System.out.print("You have chosen an invalid number. Please select a valid level: ");
            chosenLevel = input.nextLine();
        }

        System.out.println("You have chosen level " + chosenLevel);
        System.out.println("Let us begin. Generating number...");

        int chosenInt = Integer.parseInt(chosenLevel);
        int min = 1;
        int max = 0;
        if (chosenInt== 1)
            max = 10;
        else if (chosenInt== 2)
            max = 100;
        else if (chosenInt== 3)
            max = 1000;
        else if (chosenInt== 4)
            max = 10000;

        int number = generateRandom(min,max);

        System.out.print("Now pick a number between " + min + " and " + max + ": ");
        String userGuess = input.nextLine();

        int guessCount = 1;

        while(userGuess.equals("") || Integer.parseInt(userGuess) < min || Integer.parseInt(userGuess) > max)
        {
            System.out.print("Please provide a number between " + min + " and " + max + ": ");
            userGuess = input.nextLine();
        }

        while(Integer.parseInt(userGuess) != number)
        {
            if (Integer.parseInt(userGuess) > number)
                System.out.print("Your guess was too high. Try again: ");
            else if (Integer.parseInt(userGuess) < number)
                System.out.print("Your guess was too low. Try again: ");
            userGuess = input.nextLine();
            guessCount++;
        }

        if (Integer.parseInt(userGuess) == number)
        {
            System.out.println("Congratulations! The number was " + number + ". You took " + guessCount + "  guesses to find this number.");

            allScores.add(guessCount);

            System.out.print("Do you wish to play again? Type " + (char)34 + "yes" + (char)34 + " or " + (char)34 + "no" + (char)34 + ": ");
            String replay = input.nextLine();
            while (!replay.equalsIgnoreCase("yes") && !replay.equalsIgnoreCase("no"))
            {
                System.out.print("Please provide a valid response. Do you wish to play again? Type " + (char)34 + "yes" + (char)34 + " or " + (char)34 + "no:" + (char)34);
                replay = input.nextLine();
            }
            if (replay.equalsIgnoreCase("yes"))
            {
               System.out.println();
               runGame(chosenLevel, input, allScores);
            }
            else if (replay.equalsIgnoreCase("no"))
            {
                System.out.println("Thanks for playing!");
                System.out.println("Here are your scores: " + allScores);
            }
        }
    }
    public static String[] addToArray (String num)
    {
        String[] list = num.split(" ");
        return list;
    }
    public static int generateRandom(int min, int max)
    {
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

}
