package com.cs3240.parsergenerator;

import java.io.FileNotFoundException;

import com.cs3240.parsergenerator.Domain.Grammar;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
//    	Scanner scan = new Scanner(new BufferedReader(new FileReader(args[0])));
//   
//    	StringBuffer output = new StringBuffer();
//    	
//    	while (scan.hasNext()) {
//    		String token = scan.next();
//    		if (token.contains(";")) {
//    			String nonSemi = token.substring(0, token.length()-1);
//    			String semi = token.substring(token.length()-1);
//    			output.append(LexicalClass.parseToken(nonSemi).toString() + " ");
//    			output.append(LexicalClass.parseToken(semi).toString() + " ");
//    		}
//    		else 
//    			output.append(LexicalClass.parseToken(token).toString() + " ");
//    	}
    	
    	//System.out.println(output.toString());
    	
    	//Testing grammar stuff out.
    	
    	Grammar myGrammar = GrammarFileParser.parse(args[1]);
    	System.out.println(myGrammar.toString());
    }
}
