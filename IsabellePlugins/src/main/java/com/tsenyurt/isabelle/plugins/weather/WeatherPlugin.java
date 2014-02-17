package com.tsenyurt.isabelle.plugins.weather;

import java.util.ArrayList;
import java.util.List;

import com.tsenyurt.isabelle.framework.IActionPack;
import com.tsenyurt.isabelle.framework.IProcessingPack;
import com.tsenyurt.isabelle.plugins.IIsabellePlugin;

public class WeatherPlugin implements IIsabellePlugin {
	List<String> keywordList = new ArrayList<String>();

	public List<String> getRegistryWords() {
		// TODO Auto-generated method stub
		List<String> keywordList = new ArrayList<String>();
		keywordList.add("weather");
		keywordList.add("wt");
		keywordList.add("hava");
		keywordList.add("havadurumu");
		return keywordList;
	}

	public IActionPack processEvents(IProcessingPack ppack) {
		// TODO Auto-generated method stub
		return null;
	}

}
