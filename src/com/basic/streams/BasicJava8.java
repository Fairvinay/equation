package com.basic.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicJava8 { 
	
	
	public static void main(String[] args) {
		
		String [][] candidates = { {"01-05-2010" , "1", "tejas", "khanna", "u2342","2"} , 
					{"01-05-2010" , "2", "tejas", "khanna", "u2342","2"},
					 {"02-05-2000" , "3", "Veram", "Shamra", "u2322","1"},
					 {"02-11-1997" , "4", "Sagar", "Samule", "u2311","2"},
					{"01-09-2003" , "5", "Umeshr", "Dekan", "u2309","1"}
					};

		     List<String> lst = new ArrayList<>();
			Arrays.stream(candidates)
						.forEach(x  -> { if (x.getClass().isArray() ) {
							     Arrays.stream(x).forEach(p -> lst.add(p));
						} });
						
			
			lst.forEach(x -> { if ( x instanceof String ) {
				  System.out.print(x + "");
			}});
			

	}
}
