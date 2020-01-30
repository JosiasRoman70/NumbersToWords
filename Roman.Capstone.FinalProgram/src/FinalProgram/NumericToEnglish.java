package FinalProgram;

import javax.swing.JOptionPane;

public class NumericToEnglish 
{

	public NumericToEnglish() 
	{
		String results ="";
		String temp= "";
	 
		String input = JOptionPane.showInputDialog(null, "Enter A Number");
		
		if(Double.parseDouble(input) > 999999 || Double.parseDouble(input)< -999999) // validate for correct inputs, convert input into a double
				JOptionPane.showMessageDialog(null, input + "is not valid");
		
		if(input.charAt(0) == '-') 
			results += "negative "; // word negative is the first word in the built string 
		
		if(input.charAt(0) == '-' || input.charAt(0)=='+' ) // remove sign from string input, if signs are the first character
			input = input.substring(1);
		
		if(findDecimalInCorrectPosition(input))
		{
			input = rounding(Double.parseDouble(input), 3);
			
			if(input.length() > 3)
			{
				for(int a = 0; a < input.length()-3; a++)
				{
					temp += input.charAt(a);
				}
				
				results += ConvertThreeNumbers(temp) + " thousand ";
			}
			
			results += ConvertThreeNumbers(input);
			
			JOptionPane.showMessageDialog(null, input+ " converted into words is " + results);
		}
		else
			if(input.length() > 3)
			{
				for(int a = 0; a < input.length()-3; a++)
				{
					temp += input.charAt(a);
				}
				
				results += ConvertThreeNumbers(temp) + " thousand ";
			}
			
			results += ConvertThreeNumbers(input);
			
			JOptionPane.showMessageDialog(null, input+ " converted into words is " + results);

		
	}

	public char findFigures(String number, int digit)
	{
		int numberOfFigures = number.length();
		
		numberOfFigures -= digit;
		
		return number.charAt(numberOfFigures);
	}
	
	public String DecodeOnesAndHundredsChar(char theChar)
	{
		String theWord;
		
		switch (theChar)
		{
		case '0':
			theWord = "";
			break;
			
		case '1':
			theWord = "one";
			break;
			
		case '2':
			theWord = "two";
			break;
			
		case '3':
			theWord = "three";
			break;
			
		case '4':
			theWord = "four";
			break;
			
		case '5':
			theWord = "five";
			break;
			
		case '6':
			theWord = "six";
			break;
			
		case '7':
			theWord = "seven";
			break;
			
		case '8':
			theWord = "eight";
			break;
			
		case '9':
			theWord = "nine";
			break;
			
		default:
			theWord = "error";
			break;
		}
		return theWord;
	}

	public String teens(String number)
	{ 
		String word;
		char figure = findFigures(number, 1);
		
		switch(figure)
		{
		case '0':
			word = "";
			break;
			
		case '1':
			word = "eleven";
			break;
			
		case '2':
			word = "twelve";
			break;
			
		case '3':
			word = "thirtee";
			break;
			
		case '4':
			word = "fourteen";
			break;
			
		case '5':
			word = "fifteen";
			break;
			
		case '6':
			word = "sixteen";
			break;
			
		case '7':
			word = "seventeen";
			break;
			
		case '8':
			word = "eighteen";
			break;
			
		case '9':
			word = "nineteen";
			break;
			
		default:
			word = "error";
			break;
		}
	
		return word;
	}
		



	public String tens(char Figure , String number)
	{
		String word;
	
		switch(Figure)
		{
		case '0':
			word = "";
			break;
			
		case '1':
			word = teens (number);
			break;
			
		case '2':
			word = "twenty";
			break;
			
		case '3':
			word = "thirty";
			break;
			
		case '4':
			word = "fourty";
			break;
			
		case '5':
			word = "fifty";
			break;
			
		case '6':
			word = "sixty";
			break;
			
		case '7':
			word = "seventy";
			break;
			
		case '8':
			word = "eighty";
			break;
			
		case '9':
			word = "ninety";
			break;
			
		default:
			word = "error";
			break;
		}
		
		return word;
	}
	
	public String convertOnes(String number)
	{
		char figure = findFigures(number, 1);
		
		return DecodeOnesAndHundredsChar(figure);
	}
	
	public String convertTens(String number)
	{
		if(number.length() > 1)
		{
			char figures = findFigures(number, 2);
	
			if(figures == '1')
			{
				return teens(number);
				
			}
			
			else
			{
				return tens(figures, number) + " ";
			}
		}
		
		return "";
		
	 }
		
	public String convertHundreds(String number)
	{
		if(number.length() > 2)
		{
			char figures = findFigures(number, 3);
			
			return DecodeOnesAndHundredsChar(figures) + " hundred ";
		}
		
		return "";
	
	}
	
	public String ConvertThreeNumbers(String number)
	{
		String results;
		
		results = convertHundreds(number);
		
		results += convertTens(number);
		
		if(number.length() > 1 && findFigures(number, 2) != '1')
		{
			results += convertOnes(number);
		}
		
		return results;
	}
	

    public boolean findDecimalInCorrectPosition(String userInput)
    {
        if(userInput.contains("."))
        {
            if(userInput.charAt(userInput.length()-1) == '.' || userInput.charAt(userInput.length()-2) == '.')
            	return true;
        }

        return false;
    }
    
    public String rounding(double number, int place)
    {
    	number /= Math.pow(10, 3);

    	double tempDouble = (number * Math.pow(10, place));
     
    	tempDouble += .5;
    	
    	int tempInt = (int) tempDouble;
    	
    	return Integer.toString(tempInt);
    }
		
}
		


