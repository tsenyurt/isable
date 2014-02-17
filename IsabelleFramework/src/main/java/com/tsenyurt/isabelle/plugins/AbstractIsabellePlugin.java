package com.tsenyurt.isabelle.plugins;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractIsabellePlugin {
	List<String> registeredKeywords = new ArrayList<String>();

	
	
	public List<String> getRegisteredKeywords() {
		return registeredKeywords;
	}

	public void setRegisteredKeywords(List<String> registeredKeywords) {
		this.registeredKeywords = registeredKeywords;
	}
	
}
