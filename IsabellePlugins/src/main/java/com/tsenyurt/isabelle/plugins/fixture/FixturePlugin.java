package com.tsenyurt.isabelle.plugins.fixture;

import com.tsenyurt.isabelle.framework.IActionPack;
import com.tsenyurt.isabelle.framework.IProcessingPack;
import com.tsenyurt.isabelle.plugins.AbstractIsabellePlugin;
import com.tsenyurt.isabelle.plugins.IIsabellePlugin;

public class FixturePlugin extends AbstractIsabellePlugin implements IIsabellePlugin{

	public IActionPack processEvents(IProcessingPack ppack) {
		// TODO Auto-generated method stub
		System.out.println("Fixture Plugin: processing events.");
		return null;
	}

}
