package com.cs3240.parsergenerator.Domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bobby
 * The master class for the Grammar.  This will keep a Mapping of all the Symbols 
 * and their names.  This will also be able to get out all the rules for each 
 * non-terminal by keeping a mapping of nonterminal symbols to rules.
 * 
 * TODO Make it so that a nonterminal can have multiple rules.
 */
public class Grammar {
	private Map<String, Symbol> mapOfSymbols;
	private Map<NonterminalSymbol, List<String>> rulesMap;
	
	public Grammar() {
		this.mapOfSymbols = new HashMap<String, Symbol>();
		this.rulesMap = new HashMap<NonterminalSymbol, List<String>>();
	}
	
	/**
	 * Adds a symbol to this grammar.
	 * @param symbol The symbol to add.
	 */
	public void addSymbol(Symbol symbol) {
		mapOfSymbols.put(symbol.getName(), symbol);
	}
	
	/**
	 * Gets the symbol from the mapOfSymbols
	 * @param name Name of Symbol to get
	 * @return the Symbol associated with the name.
	 */
	public Symbol getSymbol(String name) {
		return mapOfSymbols.get(name);
	}
	
	/**
	 * Adds a rule to the rules map.   
	 * 
	 * @param symbol A Nonterminal, since they are only symbols with rules
	 * @param rule The rule for this nonterminal
	 */
	public void addRule(NonterminalSymbol symbol, List<String> rule) {
		rulesMap.put(symbol, rule);
	}
	
	/**
	 * This gets the rule with Symbols in it out of the map. 
	 * @param symbol The nonterminal that we are getting the rule for.
	 * @return a List of Symbols representing the rule for this nonterminal.
	 */
	public List<Symbol> getRule(NonterminalSymbol symbol) {
		List<String> rawRule = rulesMap.get(symbol);
		List<Symbol> modifiedRule = new ArrayList<Symbol>();
		for (String s : rawRule) {
			Symbol nextSymbol = mapOfSymbols.get(s);
			modifiedRule.add(nextSymbol);
		}
		return modifiedRule;
	}

}
