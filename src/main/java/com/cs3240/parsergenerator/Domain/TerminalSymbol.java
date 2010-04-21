package com.cs3240.parsergenerator.Domain;

/**
 * @author Bobby
 * This is the terminal symbol.  This will only have a name and value, as terminal
 * symbols do not have rules or anything else associated with them.
 */
public class TerminalSymbol extends Symbol {
	private String value;
	
	public TerminalSymbol(final String name) {
		this.setName(name);
	}
	
	public TerminalSymbol(final String name, final String value) {
		this.setName(name);
		this.setValue(value);
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	

}
