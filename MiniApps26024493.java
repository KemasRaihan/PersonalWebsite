package miniApps;

import java.util.Scanner;
import java.util.Random;

public class MiniApps26024493{
	
  public static void main(String[] args) {
	  LaunchMenu();
  }
  /**************************************************************************************************************************************
   *                                                                Menu
   * ************************************************************************************************************************************/
/*Test plan: 
 * -If I input 1. in the scanner input, as menuSelect, then it should access the PlayKeepCounting() function. 
 * -2, 3, 4 will activate the AccessNumberConversionTool(), AccessUPCCalculator(), AccessUPCChecler() functions respectively.
 * -9 will print 'Bye...' and break out of the loop.
 * -If I input a number between 4 and 9 (inclusive), it should print 'Unrecognised option, please try again: ', go through the loop again
 * and go through the scanner input again.
 *  -If I input any other number, for example -10 or 120, it should print 'Invalid option, please try again: ' go through the loop again
 * and go through the scanner input again..*/
  
  public static void LaunchMenu()
  {
    Scanner input = new Scanner(System.in);
    System.out.println("P4CS Mini Applications");
    System.out.println("-----------------------");
    System.out.println("Please select an option: ");
    System.out.println("1) Keep Counting Game");
    System.out.println("2) Number Conversion Tool");
    System.out.println("3) Universal Product Code (UPC) Calculator");
    System.out.println("4) Universal Product Code (UPC) Checker");
    System.out.println("9) Quit");
    System.out.println("Please enter option:");
    ChooseApp(input);
  }
  
  public static void ChooseApp(Scanner input)
  {
    boolean valid = false;
	do {
		int menuSelect = input.nextInt();
		if(menuSelect == 1)
		  {
		    AccessKeepCounting(input);
		  }
		    else if(menuSelect == 2)
		    {
		    	AccessNumberConversionTool(input);
		    }
		    else if(menuSelect == 3)
		    {
		    	AccessUPCCalculator(input);
		    }
		    else if(menuSelect == 4)
		    {
		    	AccessUPCChecker(input);
		    }
		    else if(menuSelect > 4 && menuSelect < 9)
		    {
		    	System.out.println("Unrecognised option, please try again: ");
		    }
		    else if(menuSelect == 9)
		    {
		    	System.out.println("Bye...");
		    	valid = true;
		    }
		    else
		    {
		    	System.out.println("Invalid option, please try again: ");
		    }
	  }while(!valid);
  
  }
   /**************************************************************************************************************************************
    *                                                           Keep Counting
    * ************************************************************************************************************************************/
/*Test plan:
 * 
 * -Activated the KeepCounting() function many times to make sure that both the operator and the second operand is randomly generated for 
 * each question, and that the first operand is randomly generated in the first question.
 * 
 * -Answered one question incorrectly and it should break the while loop and print message 'Incorrect, the answer was + correctAnswer'.
 * 
 * -Answered all questions correctly in approximately 20 seconds and the message should read 'Questions completed in 20 seconds'.
 * 
 * -Answered all questions correctly in approximately 45 seconds and the message should read 'Questions completed in 45 seconds'.
 * 
 * -Answered all questions correctly in approximately 60 seconds and the message should read 'Questions completed in 60 seconds'*/
  
  public static void AccessKeepCounting(Scanner input)
  {
    System.out.println("Keep Counting");
    System.out.println("---------------");
    System.out.println("You will be presented with 8 additional questions.");
    System.out.println("After the first question, the left-hand operand is");
    System.out.println("the result of the previous addition");
    System.out.println("Press enter to start...\n");
    PlayKeepCounting(input);
  }
  
  public static void PlayKeepCounting(Scanner input)
  {
	int number = 1;
	int min = 1, max = 9;
	int userInput, firstOperand, secondOperand;
	int correctAnswer;
	firstOperand = 0;

    long startTime = System.currentTimeMillis();
    
    while(number <= 8) {
  
    	secondOperand = (int)(Math.random() * (max - min+1) + min);
    	
	    if(number == 1){ 
	    	firstOperand = (int)(Math.random() * (max - min+1) + min);
	    	correctAnswer = 0;
	    }
	    
	    String randomOperator = FlipCoin();
	    
	    System.out.println("Question " + number + ": " + firstOperand + " " + randomOperator + " " + secondOperand + " = ");
	    userInput = input.nextInt();

	    correctAnswer = 0;
	    switch(randomOperator) {
	      case "+": correctAnswer = firstOperand + secondOperand; break;
	      case "-": correctAnswer = firstOperand - secondOperand; break;
	      }
	    
	   if(userInput == correctAnswer) {
	    number++;
	    firstOperand = correctAnswer;
	   }else {
	    System.out.println("Incorrect. The answer was " + correctAnswer + ".\n");
	   }
	   }
    long endTime = System.currentTimeMillis();
    int timeElapsedInSeconds = (int) (endTime - startTime) / 1000;
    
    System.out.println("Questions completed in " + timeElapsedInSeconds + " seconds\n");
  }
  
  public static String FlipCoin() 
  {
	  //operator will have 50% chance of being assigned either '+' or '-'
	    String operator;
	    if(Math.random() < 0.5)
	    {
	    	operator = "+";
	    }else
	    {
	    	operator = "-";
	    }
	    return operator;
  }
  /**************************************************************************************************************************************
   *                                                           Number Conversion Tool
   * ************************************************************************************************************************************/
  /*Test Plan:
   * ---------
   * 
   *-If we input a number less than 0 it should print 'Invalid input please try again' and goes through do while loop again.
   *
   *-The if statements from both ConvertToBinary() and ConvertToHex() functions, removes the first digit at the beginning to avoid the 0 padding 
   *at the beginning, so we input 'number = 0' to make sure that it's not affected by it and should print 'Binary: 0 Hex: 0'.  
   *
   *Similarly, we input 'number = 1' to make sure it does not affect it too and print 'Binary: 1 and Hex: 1'
   *I input 'number = 2' to make sure the binary is in base 2 and print 'Binary: 10 and Hex: 2'.
   *
   *Similarly, we input 'number = 16' to make sure that the if statement from ConvertToBinary() does not remove the first digit and
   *hexadecimal is in base 16 and print 'Binary: 1000 and Hex: 10'.
   *
   *To make sure that the switch statement from ConvertToHex() is working properly, we input decimals which have letters in its hexadecimal
   *in this case 'number = 10' and it should print 'Hex is A'.
   *
   *We also input other decimals which have letters, other than 'A' in their hexadecimal in this case 'number = 11', 'number = 12', 'number = 13', 
   *'number = 14', and 'number = 15', and it should print 'Hex : B', Hex: C', 'Hex: D', and 'Hex E' respectively.
   *
   *To make sure that the function ConvertToHexadecimal() can print out a hexadecimal consisting of digits and letters, we input 'number = 31' and I
   *expect the output to be 'Hex: 1F'
   *
   *Finally, we input 'number = 10000' to make sure there is no limit to what positive base-10 integer can be place as an input, so it should print 
   *'Binary: 10011100010000 and Hex: 2710.
   * */
  
  public static void AccessNumberConversionTool(Scanner input)
  {
	  System.out.println("Number Conversion Tool");
	  System.out.println("-----------------------");
	  System.out.println("Please enter a positive base-10 number: ");
	  CheckValidNumber(input);
  }
  
  public static void CheckValidNumber(Scanner input)
  {
	  boolean valid = false;
	  
	  do {
		  int number = input.nextInt();
		  if(number >= 0)
		  {
			  ConvertToBinary(number);
			  ConvertToHexadecimal(number);
			  System.out.println("\n");
		  }
		  else
		  {
			  System.out.println("Invalid input please try again");
		  }
		  }while(!valid);
  }

  public static void ConvertToBinary(int number)
  {
	  String binary = "";
	  int base = ObtainBaseLimit(2, number);
	  boolean paddingRemoved = false;
	  while(base >= 1){
		  /*if statement used to remove unnecessary 0 padding at the beginning*/
		  if(base > number && number != 0 && !paddingRemoved)
		  {
			  paddingRemoved = true;
			  base/=2;
			  continue;
		  }
		  
		  if(number - base >= 0)
		  {
			  binary+="1";
			  number-=base;
		  }
		  else 
		  {
			  binary+="0";
		  }
		  base/=2;
	  }
	System.out.println("Binary: " + binary);
  }

  public static void ConvertToHexadecimal(int number)
  {
	  String hex = "";
	  boolean paddingRemoved = false;
	  int base = ObtainBaseLimit(16, number);
	  while(base >= 1)
	  {	
		  /*if statement used to remove the unnecessary 0 padding at the beginning*/
		  if(base > number && number != 0 && !paddingRemoved)
		  {
			  paddingRemoved = true;
			  base /= 16;
			  continue;
		  }
		int numberOf16s = number / base;
		if(numberOf16s >= 0 && numberOf16s <= 9)
		{
			hex+=Integer.toString(numberOf16s);
		}
		else 
		{
			//if 9 < numberOf16s < 16
			switch(numberOf16s)
			{
			case 10: hex+="A";break;
			case 11: hex+="B";break;
			case 12: hex+="C";break;
			case 13: hex+="D";break;
			case 14: hex+="E";break;
			case 15: hex+="F";break;
			}
		}
		number-=base*numberOf16s;
		base /= 16;
	  }
		
	System.out.println("Hex: " + hex);
	}
  
  public static int ObtainBaseLimit(int base, int number)
  {
	  int baseLimit = 1;
	  while(number > baseLimit)
	  {
		baseLimit *= base;
	  }
	  return baseLimit;
  }
  
  /**************************************************************************************************************************************
   *                                                   Universal Product Code (UPC) Calculator
   * ************************************************************************************************************************************/
/*Test plan: 
 * ---------
 * 
 * -Firstly, we input 'number = 1000000' and 'number = -1' to make sure we do not break out of the loop in CheckNumberOfDigits() and it should
 * print 'Invalid input, please enter again: ' until we write a positive integer that contains no more than 6 digits.
 * 
 * -Secondly, as a baseline, I input number = '123456' and I expect it to print'The 7-digit final UPC is: 1234561'.
 * 
 * -Also, to make sure that the 0 padding in the function UPCSeparateDigits() is working properly, we input 'number = 123' and it should return 
 * an array equal to '[0,0,0,1,2,3]'. The ShowUPCCode() function should also not print the 0 paddings and the final UPC code should be 
 * '1230'.
 * 
 * */
  public static void AccessUPCCalculator(Scanner input)
  {
	  System.out.println("Universal Product Code (UPC) Calculator");
	  System.out.println("----------------------------------------");
	  System.out.println("Please enter 6-digit code to generate final UPC Code: ");
	
	  int number = input.nextInt();
	  int digitLimit = 6;
	  int[] codeArray = new int[digitLimit + 1];
	  CheckNumberOfDigits(input, number, digitLimit);
	  
	  UPCSeperateDigits(input, number, codeArray);
	  CalculateUPCFinalDigit(input, codeArray);
	  ShowFinalUPCCode(input, codeArray);
  }
  
  public static int CheckNumberOfDigits(Scanner input, int number, int digitLimit)
  {	
	  boolean valid = false;
	  do {
		  if(number < 0 || (int)(number / (Math.pow(10, digitLimit))) != 0)
		  {
			System.out.println("Invalid input, please enter again: ");
			number = input.nextInt();
		  }
		  else 
		  {
			  valid = true;
		  }
	  }while(!valid);
	  return number;
  }
  
  public static void UPCSeperateDigits(Scanner input, int number, int[] codeArray)
  {
	  int codeIndex = 0;
	  int numberOfDigits = 6;
	  
	  while(numberOfDigits > 0)
	  {
		  int base = (int) Math.pow(10, numberOfDigits-1);
		  
		  //Add 0s to start of array if number has less than 6 digits
		  if(number / base == 0)
		  {
			  codeArray[codeIndex] = 0;
			  codeIndex++;
		  }
		  else 
		  {
			  SeperateDigits(number, codeArray, numberOfDigits, codeIndex);
			  break;
		  }
		  numberOfDigits--;
	  }
  }
  public static void SeperateDigits(int number, int[] digitsArray, int numberOfDigits, int index)
  {
	  int[] numberArray = new int[numberOfDigits];
	  for(int remainIndex = 0; remainIndex < numberOfDigits; remainIndex++)
	  {
		  numberArray[remainIndex] = number / (int) Math.pow(10, numberOfDigits - remainIndex - 1);
		  for(int subtractIndex = 0; subtractIndex < remainIndex; subtractIndex++)
		  {
			  numberArray[remainIndex] -= numberArray[subtractIndex] * (int) Math.pow(10, remainIndex-subtractIndex);
		  }
		  digitsArray[index] = numberArray[remainIndex];
		  index++;
	  }
  }
  
  public static void CalculateUPCFinalDigit(Scanner input, int[] codeArray)
  { 
	  int total = CalculateSum(codeArray);
	  int remainder = total % 10;
	  int finalDigit;
	  
	  if(remainder == 0)
	  {
		  finalDigit = remainder;
	  }
	  else 
	  {
		finalDigit = 10 - remainder; 
	  }
	  codeArray[6] = finalDigit;
  }
  
  public static int CalculateSum(int[] codeArray) {
	//Calculates sum of digits in odd positions sum of digits in even positions
	  int sumOfDigitsOdd = 0;
	  int sumOfDigitsEven = 0;
	  
	  int evenNumber;

	  for(int oddNumber = 0; oddNumber < 6; oddNumber+=2)
	  {
		 evenNumber = oddNumber + 1;
		 sumOfDigitsOdd += codeArray[oddNumber];
		 sumOfDigitsEven += codeArray[evenNumber];
	  }
	  sumOfDigitsOdd *= 3;
	  
	  int totalSum = sumOfDigitsOdd + sumOfDigitsEven;
	  return totalSum;
  }
  
  public static void ShowFinalUPCCode(Scanner input, int[] codeArray)
  {
	  int numberOfEmptyDigits = 0;
	  
	  //Used to skip printing the 0s at the start of the array
	  if(codeArray[0] == 0)
	  {
		  for(int index = 0; index < 6; index++)
		  {
			  if(codeArray[index] == 0)
			  {
				  numberOfEmptyDigits++;
			  }
			  else if(codeArray[index] != 0)
			  {
				  break;
			  }
		  }
	  }
	  System.out.print("The 7-digit final UPC is: ");
	  for(int index = numberOfEmptyDigits; index < 7; index++)
	  {
		 System.out.print(codeArray[index]);
	  }
	  System.out.println("\n");
  }
  
  
  /**************************************************************************************************************************************
   *                                                   Universal Product Code (UPC) Checker
   * ************************************************************************************************************************************/
 /* Test plan:
  * -----------
  * 
  *-Firstly, as a baseline, we input 'userNumber = 1234561' and we expect it to print'The UPC is valid'.
  *
  *-Secondly, to make sure that it also checks for invalid UPC codes, we input 'userNumber = 1234569' and we expect it to print 
  *'an error was detected in the UPC'.
  * 
  * -We also input 'userNumber = 0', 'userNumber = 1230' and 'userNumber = 1231' to make sure it also works for UPC codes with '0' paddings.
  * Therefore, the expected outputs should be 'The UPC is valid' for '0' and '1230', and 'An error was detected in the UPC' respectively.
  * 
  * */

  public static void AccessUPCChecker(Scanner input)
  {
	  System.out.println("Universal Product Code (UPC) Checker");
	  System.out.println("----------------------------------------");
	  System.out.println("Please enter 7-digit UPC to check: ");
	  CalculateActualUPC(input);
  }
  
  public static void CalculateActualUPC(Scanner input)
  {
	  int digitLimit = 7;
	  
	  //Array for digits of user input number
	  int[] userArray = new int[digitLimit];
	  int userNumber = input.nextInt(); 
	  
	  userNumber = CheckNumberOfDigits(input, userNumber, digitLimit);
	  int numberOfUserDigits = ObtainNumberOfDigits(userNumber);
	  SeperateDigits(userNumber, userArray, numberOfUserDigits, 0);
	  
	  //Array for digits used to calculate UPC
	  int[] UPCArray = new int[digitLimit];
	  
	  //Removes last digit of user input number
	  int calculatedUPC = (int) userNumber / 10;
	  
	  UPCSeperateDigits(input, calculatedUPC, UPCArray);
	  CalculateUPCFinalDigit(input, UPCArray);
	  
	  CompareFinalDigits(UPCArray, userArray, digitLimit, numberOfUserDigits);
  }
  
  public static int ObtainNumberOfDigits(int number) 
  {
	 int numberOfDigits = 1;
	 int log10 = 10;
	 
	//Calculate number of digits of the number that the user inputs
	  while(number / log10 != 0)
	  {
		  numberOfDigits++;
		  log10 *= 10;
	  }
	  return numberOfDigits;
  }
  
  public static void CompareFinalDigits(int[] UPCArray,  int[] userArray, int digitLimit, int numberOfUserDigits)
  {
	  //Determine if both final digits of user input number and its UPC are equal
	  if(UPCArray[digitLimit-1] == userArray[numberOfUserDigits-1])
	  {
		  System.out.println("\nThe UPC is valid");
	  }
	  else 
	  {
		  System.out.println("\nAn error was detected in the UPC");
	  }
	  System.out.println("\n");
 }
  
}
