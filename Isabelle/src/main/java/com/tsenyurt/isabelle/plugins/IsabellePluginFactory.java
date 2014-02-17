package com.tsenyurt.isabelle.plugins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.tsenyurt.isabelle.plugins.fixture.FixturePlugin;
import com.tsenyurt.isabelle.plugins.weather.WeatherPlugin;

public class IsabellePluginFactory {
	public List<IIsabellePlugin> getActivePluginList(){
		List<IIsabellePlugin> activePluginList = new ArrayList<IIsabellePlugin>();
		
		List<String> classnames = new ArrayList<String>();
		classnames.add(WeatherPlugin.class.getName());
		classnames.add(FixturePlugin.class.getName());
		
		
		try{
			for (Iterator iterator = classnames.iterator(); iterator.hasNext();) {
				String classname = (String) iterator.next();
				Class pluginClass = Class.forName(classname);
				IIsabellePlugin plugin = (IIsabellePlugin) pluginClass.newInstance(); 
				activePluginList.add(plugin);
			}
		}catch(Exception ex){
			System.out.println("Class not found ex.");
		}
		
		return activePluginList;
	}
	
}
