package stack.commons.maths;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatherII {
	
	
	public boolean isPlusOrMinusOperator(char c) {
		return ( c == '+'
				|| c == '-'
				
				);
	}
	
	public boolean isOperator(char c) {
		return ( c == '+'
				|| c == '-'
				|| c == '*'
				|| c == '/'
				);
	}
	
	public int getIndexOfNextOperator(String expression) {
		
		int result = -1;
		for (int i = 0; i < expression.length(); i++) {
			if (isOperator(expression.charAt(i))) {
				result = i;
				break;
			}
		}
		return result;
	}
	
	public String preProcessExpression(String expression) {
		
		// Pass N1: replace every +- by -
		// Pass N2: replace evert -+ by -
		// Pass N3: replace -number by (0-number)
		
		if (isPlusOrMinusOperator(expression.charAt(0))) {
			int indexOfNextOperator = getIndexOfNextOperator(expression.substring(1));
			String numberStr = expression.substring(1, indexOfNextOperator+1);
			return preProcessExpression("(0" + expression.charAt(0) +numberStr + ")" + expression.substring(indexOfNextOperator+1) );
			
		} else {
			List<Integer> toDelete = new ArrayList<Integer>();
			for (int i = 0; i < expression.length()-1; i++) {
				if (expression.charAt(i) == '+' && expression.charAt(i+1) == '-') {
					toDelete.add(i);
				} else if (expression.charAt(i)== '-' && expression.charAt(i+1)== '+') {
					toDelete.add(i+1);
				}
				
			}
			
			for (int index: toDelete) {
				expression = expression.replace(expression.charAt(index)+"", "D");
			}
			expression = expression.replaceAll("D", "");
			
			
		}
		
		return expression;
		
		
	}
	
	
	public int parenthesisEvalExpression(String expression) {
		
		if (!expression.contains("(")) {
			//System.out.println(expression +  "has no parenthesis");
			return evalExpression(expression);
		} else {
			
			int openParenthesisIndex = expression.lastIndexOf("(");
			int closeParenthesisIndex = expression.substring(openParenthesisIndex).indexOf(")")+openParenthesisIndex;
			String inParenthesisExpression = expression.substring(openParenthesisIndex+1, closeParenthesisIndex);
			System.out.println("Expression to evaluate in between :" + inParenthesisExpression);
			
			int inResult = parenthesisEvalExpression(inParenthesisExpression);
			String exPressionToReplace = expression.substring(openParenthesisIndex, closeParenthesisIndex+1);
			String newExpression = expression.replace(exPressionToReplace, inResult+"");
			return parenthesisEvalExpression(newExpression);
			
		}
	}
	
	
	public int evalExpression (String expression) {
		int operatorIndex = getOperatorIndex(expression); 
		if (-1 == operatorIndex) {
			return Integer.parseInt(expression);
		} else {
			String splittPattern =  "\\" + expression.charAt(operatorIndex)+"";//expression.substring(operatorIndex, operatorIndex+1);
			String[] operands = expression.split(splittPattern, 2);
			System.out.println("Operand 1 = " + operands[0]);
			System.out.println("Operand 2 = " + operands[1]);
			
			return performOperation (splittPattern.charAt(1),    evalExpression(operands[0]), evalExpression(operands[1]));
			
				
		}
	}
	
	
	public int performOperation (char operator, int operand1, int operand2) {
	
		int result = 0;
		switch (operator) {
			case '+':
				result = operand1+operand2;
				break;
			case '-':
				result = operand1-operand2;
				break;
			case '*':
				result = operand1*operand2;
				break;
			case '/':
				if (operand2 == 0) {
					throw new NullPointerException();
				} else {
					result = operand1/operand2;
				}
				break;
			default:
					break;
			
		}
		
		return result;
	}
	
	public int getOperatorIndex(String expression) {
		
		int result = -1;
		
		boolean hasNotPlusOperator = !expression.contains("+");
		boolean hasNotMinusOperator = !expression.contains("-");
		boolean hasNotTimesOperator = !expression.contains("*");
		boolean hasNotDivisionOperator = !expression.contains("/");
		
		if (hasNotPlusOperator && hasNotMinusOperator && hasNotTimesOperator && hasNotDivisionOperator) {
			return result;
		}
		
		if (!hasNotPlusOperator) {
			result = expression.indexOf("+");
			//System.out.println("Find + operator at index " + result);			
			return result;
			
		} else if (!hasNotMinusOperator) {
			
			result = expression.indexOf("-");			
			return result;
			
		}  else if (!hasNotTimesOperator) {
			
			result = expression.indexOf("*");			
			return result;
			
		} else if (!hasNotDivisionOperator) {
			
			result = expression.indexOf("/");			
			return result;
			
		}
		
		
		return result;
	}
	
public static void main(String[] args) {
		
		MatherII mII = new MatherII();
		int fivePlusSix = mII.parenthesisEvalExpression("5+6");
		System.out.println("5 + 6 result = " + fivePlusSix);
		int fixePlusSevenTimesThree = mII.parenthesisEvalExpression("5+7*3");///.evalExpression("5+7*3");
		System.out.println("5+7*3 result = " + fixePlusSevenTimesThree);
		
		String expression = "";
		Scanner scanner = new Scanner (System.in);
		
		while (true) {
			System.out.println("Enter a new expression: ");
			expression = scanner.next();
			if ("EXIT".equals(expression.toUpperCase().trim())) {
				break;
			}
			
			String preprocessedExpression = mII.preProcessExpression(expression);
			System.out.println("The preprocessed expression : " + preprocessedExpression);
			
			//int result = mII.parenthesisEvalExpression(expression);
			int result = mII.parenthesisEvalExpression(preprocessedExpression);
			System.out.println("The result of " + expression +" = " + result);
			
		}
		
	}

}
