package week5;
import java.util.Scanner;

public class SnakeEyes {
	public static String name;
	public static int highScore = 0;
	public static void main(String[] args) 
	{
		SnakeEyes();
	}
	
	
	private static void SnakeEyes() 
	{
		Scanner input=new Scanner(System.in);
		int score = 0;
		int numberOfThrows = 1;
		
		System.out.println("Welcome to Snake Eyes. Are you ready to play (y/n)?");
		String answer=input.next();
		switch(answer) 
		{
		case "y": PlayGame(score, numberOfThrows);
		case "n": System.out.println("Ready when you are then."); SnakeEyes();
		default: InvalidInput(input, score, numberOfThrows);
		}
		
	}
	
	private static void InvalidInput(Scanner input, int score, int numberOfThrows)
	{
		System.out.print("Invalid input. Please try again: ");
		String answer=input.next();
		switch(answer) 
		{
		case "y": PlayGame(score, numberOfThrows);
		case "n": System.out.println("Ready when you are then."); SnakeEyes();
		default: InvalidInput(input, score, numberOfThrows);
		}
	}
	
	
	private static void DisplayDiceFace(int value)
	{
		switch(value) 
		{
		case 1: 
			System.out.println("*********");
			System.out.println("*       *");
			System.out.println("*      1*");
			System.out.println("*      1*");
			System.out.println("*      1*");
			System.out.println("*      1*");
			System.out.println("*      1*");
			System.out.println("*       *");
			System.out.println("*********");
			break;
		case 2: 
			System.out.println("*********");
			System.out.println("*       *");
			System.out.println("* 2222  *");
			System.out.println("*    2  *");
			System.out.println("* 2222  *");
			System.out.println("* 2     *");
			System.out.println("* 2222  *");
			System.out.println("*       *");
			System.out.println("*********");
			break;
		case 3: 
			System.out.println("*********");
			System.out.println("*       *");
			System.out.println("* 3333  *");
			System.out.println("*    3  *");
			System.out.println("* 3333  *");
			System.out.println("*    3  *");
			System.out.println("* 3333  *");
			System.out.println("*       *");
			System.out.println("*********");
			break;
		case 4: 
			System.out.println("*********");
			System.out.println("*       *");
			System.out.println("* 4  4  *");
			System.out.println("* 4  4  *");
			System.out.println("* 4444  *");
			System.out.println("*    4  *");
			System.out.println("*    4  *");
			System.out.println("*       *");
			System.out.println("*********");
			break;
		case 5: 
			System.out.println("*********");
			System.out.println("*       *");
			System.out.println("* 5555  *");
			System.out.println("* 5     *");
			System.out.println("* 5555  *");
			System.out.println("*    5  *");
			System.out.println("* 5555  *");
			System.out.println("*       *");
			System.out.println("*********");
			break;
		case 6: 
			System.out.println("*********");
			System.out.println("*       *");
			System.out.println("* 6666  *");
			System.out.println("* 6     *");
			System.out.println("* 6666  *");
			System.out.println("* 6  6  *");
			System.out.println("* 6666  *");
			System.out.println("*       *");
			System.out.println("*********");
			break;
		}
	}
	
	
	private static void DoYouDare(Scanner input, int score, int numberOfThrows)
	{
		System.out.println("Do you dare throw again (y/n)?");
		String answer=input.next();
		if(answer.equals("y")||answer.equals("Y"))
		{
			PlayGame(score, numberOfThrows);
		}
		else if(answer.equals("n")||answer.equals("N"))
		{
			EndGame(score);
		}
		else 
		{
			InvalidInput(input, score, numberOfThrows);
		}
	}
	
	private static void PlayGame(int score, int numberOfThrows)
	{
		Scanner input=new Scanner(System.in);

		int dice1, dice2;

		boolean playGame = true;
		String answer="y";
		
		dice1 = RollDice();
		dice2 = RollDice();
		
		while(playGame) {
			System.out.println("Throw " + numberOfThrows);
	
			dice1 = RollDice();
			dice2 = RollDice();
		
			DisplayDiceFace(dice1);
			DisplayDiceFace(dice2);
			
			if(dice1==1 && dice2==1) 
			{
				score=-1;
				EndGame(score);
				break;
			}
			else if(dice1==6 && dice2==6) 
			{
				score=-1;
				EndGame(score);
				break;
			}
			else if(dice1 == dice2) 
			{
				score /= 2;
			}
			else 
			{
				score += dice1 + dice2;
			}
			
			numberOfThrows += 1;
			
			System.out.println("Current total: " + score);
			DoYouDare(input, score, numberOfThrows);
			answer=input.next();
		}
	}
	
	
	private static int RollDice() 
	{
		return (int) (Math.random() * 6) + 1;
	}
	

	private static void EndGame(int score) 
	{
		Scanner input = new Scanner(System.in);
		if(score==-1) 
		{
			System.out.println("You lost. Better luck next time.");
		}
		else 
		{
		    System.out.println("Well done. You beat Snake Eyes with a total of " + score);
			if(score > highScore) 
			{
				highScore = score;
				System.out.println("Well done a new high score!");
				System.out.print("Please enter your name: ");
				String name = input.next();
				SnakeEyes newHighScore = new SnakeEyes();
				newHighScore.HighScore(highScore, name);
			}
			PlayAgain(input);
		}
	}
	
	public void HighScore(int highScore, String name)
	{
		SnakeEyes.highScore = highScore;
		SnakeEyes.name = name;
	}
	
	private static void PlayAgain(Scanner input)
	{
		System.out.println("Can you beat " + name +"'s score of " + highScore + "?");
		System.out.println("Would you like to play the game again?");
		String playAgain = input.next();
		
		int score = 0;
		int numberOfThrows = 1;
		
		if(playAgain.equals("y")||playAgain.equals("Y"))
		{
			PlayGame(score, numberOfThrows);
		}
		else if(playAgain.equals("n")||playAgain.equals("N"))
		{
			System.out.println("Thanks for playing.");
		}
		else 
		{
			PlayAgainInvalidInput(input, score, numberOfThrows);
		}
	}
	
	private static void PlayAgainInvalidInput(Scanner input, int score, int numberOfThrows)
	{
		boolean valid = false;
		do {
			System.out.print("Invalid input, please try again: ");
			String playAgain = input.next();
			
			if(playAgain.equals("y")||playAgain.equals("Y"))
			{
				PlayGame(score, numberOfThrows);
			}
			else if(playAgain.equals("n")||playAgain.equals("N"))
			{
				System.out.println("Thanks for playing.");
				valid = true;
			}
		}while(!valid);
	}
}

