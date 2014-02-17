package com.tsenyurt.isabelle.plugins;

import java.util.Iterator;
import java.util.List;

public class IsabellePluginFactoryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsabellePluginFactory factory = new IsabellePluginFactory();
		List<IIsabellePlugin> plugins = factory.getActivePluginList();
		
		for (Iterator iterator = plugins.iterator(); iterator.hasNext();) {
			IIsabellePlugin iIsabellePlugin = (IIsabellePlugin) iterator.next();
			iIsabellePlugin.processEvents(null);
			
		}
	}

}
