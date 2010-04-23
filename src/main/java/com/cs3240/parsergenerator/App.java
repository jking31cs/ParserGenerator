package com.cs3240.parsergenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cs3240.parsergenerator.Domain.Grammar;
import com.cs3240.parsergenerator.Domain.NonterminalSymbol;
import com.cs3240.parsergenerator.Domain.TerminalSymbol;

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
    	
    	Scanner grammarScanner = new Scanner(new File(args[1]));
    	grammarScanner.useDelimiter("\n");
    	Grammar myGrammar = new Grammar();
    	boolean isDefiningRules = false;
    	while (grammarScanner.hasNext()) {
    		String[] lineSplit = grammarScanner.next().split(" ");
    		//Switching between Tokens, Non-terminals, Start, and Rules
    		if (lineSplit[0].trim().equals("%Tokens")) {
    			for (int i = 1; i < lineSplit.length; i++) {
    				TerminalSymbol symbol = new TerminalSymbol(lineSplit[i].trim());
    				myGrammar.addSymbol(symbol);
    			}
    		} else if (lineSplit[0].trim().equals("%Non-terminals")) {
    			for (int i = 1; i < lineSplit.length; i++) {
    				NonterminalSymbol symbol = new NonterminalSymbol(lineSplit[i].trim());
    				myGrammar.addSymbol(symbol);
    			}
    		} else if (lineSplit[0].trim().equals("%Start")) {
    			myGrammar.setStartRule(
    					(NonterminalSymbol) myGrammar.getSymbol(lineSplit[1].trim()));
    		} else if (lineSplit[0].trim().equals("%Rules")) {
    			isDefiningRules = true;
    		} else {
    			if (isDefiningRules) {
    				NonterminalSymbol symbol =
    					(NonterminalSymbol) myGrammar.getSymbol(lineSplit[0].trim());
    				List<String> rule = new ArrayList<String>();
    				for (int i = 2; i < lineSplit.length; i++) {
    					if (lineSplit[i].trim().equals("|")) {
    						myGrammar.addRule(symbol, rule);
    						rule = new ArrayList<String>();
    						continue;
    					}
    					rule.add(lineSplit[i].trim());
    				}
    				myGrammar.addRule(symbol, rule);
    			} else {
    				System.err.println("DID NOT SET RULES");
    			}
    		}
    		
    	}
    	System.out.println(myGrammar.toString());
    }
}
