package com.basic.equations;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Summation {

	static Stack<String> brackHolder = new Stack<>();
	static Queue<String> expQueue = new LinkedList<>();
	
	public static void main(String args[]) {

		if (args.length < 1) {

			System.out.println("Pass the equation as Summation 1+4 ");
			System.exit(1);
		}
		if (isValidEquation(args[0])) {
			System.out.println("Equaton is valid ");
		} else {
			System.out.println("Equaton is nit valid ");
		}
		if(!expQueue.isEmpty()) {
			System.out.println(" result "+args[0]+ " "+expQueue.peek());
		}
		else if(!brackHolder.isEmpty()) {
			System.out.println(" result "+args[0]+ " "+brackHolder.peek());
		}

	}

	public static boolean isValidEquation(String eq) {

		Pattern m = Pattern.compile("[0-9]+[(]*[)]*[+]*[/]*[-]*", 0);

		Matcher mt = m.matcher(eq);
		boolean valid = false;
		
		if (!eq.contains("[a-zA-Z]+")) {
			if (mt.find()) {

				valid = true;
				for (int i = 0; i < eq.length(); i++) {
					switch (eq.charAt(i)) {
					case '(':
						pushQExpOnStack(expQueue,"(");
						break;
					case ')':
						evaluateQueue(expQueue);
						break;
					case '1':
						expQueue.add("1");
						break;

					case '2':
						expQueue.add("2");
						break;

					case '3':
						expQueue.add("3");
						break;
					case '4':
						expQueue.add("4");
						break;
					case '5':
						expQueue.add("5");
						break;
					case '6':
						expQueue.add("6");
						break;
					case '7':
						expQueue.add("7");
						break;
					case '8':
						expQueue.add("8");
						break;
					case '9':
						expQueue.add("9");
						break;

					case '*':
						expQueue.add("*");
						break;
					case '+':
						expQueue.add("+");
						break;
					case '-':
						expQueue.add("-");
						break;
					}
				}
			}
		}
		return valid;
	}

	private static void pushQExpOnStack(Queue<String> expQueue2, String string) {
		String strExp ="";
		while (!expQueue2.isEmpty()) {
			 brackHolder.add(expQueue2.poll());
		}
		
		brackHolder.add(string);
	}

	private static void evaluateQueue(Queue<String> expQueue) {
		String strVal ="";
		while (!expQueue.isEmpty()) {
			strVal += expQueue.poll();
		}
		if(!strVal.isEmpty() ) {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		Integer result = null; 
		Integer resultPlus = null; Integer resultStar = null;
		if (strVal.indexOf("+") > -1) {
			try {
				
				resultPlus = (Integer) engine.eval(strVal);
				System.out.println(strVal +" = " +resultPlus );
			} catch (ScriptException e) {
				System.out.println("cannot evaluate ");
			}
			// calculate with * 
			String strVal2 = strVal.replace('+', '*');
			try {
				resultStar = (Integer) engine.eval(strVal2);
				System.out.println(strVal2  +" = " +resultStar );
			} catch (ScriptException e) {
				System.out.println("cannot evaluate ");
			}
			result = resultPlus.intValue() >  resultStar.intValue()? resultPlus: resultStar;
			
			expQueue.clear();
			expQueue.add(result.intValue()+"");
			
		}
       // push the queue result to stack till opening ( found 
		while(brackHolder.peek() == "(") {
			brackHolder.pop();
			brackHolder.push(expQueue.poll());
		}
	  }
	  else {while(!brackHolder.isEmpty() && brackHolder.peek() != "(") {
		  expQueue.add(brackHolder.pop());
	     }
	    if(!expQueue.isEmpty()) {
	    	evaluateQueue(expQueue);
	    }
	 }
	}

	private static void evaluateStack(Stack a) {
		boolean eval = true;
		if (a.isEmpty()) {
			eval = false;
		}

	}

}
