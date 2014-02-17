package com.tsenyurt.isabelle.plugins;

import java.util.List;

import com.tsenyurt.isabelle.framework.IActionPack;
import com.tsenyurt.isabelle.framework.IProcessingPack;

public interface IIsabellePlugin {
	public IActionPack processEvents(IProcessingPack ppack);
}
