package org.macunaima.gui.ui;

import java.util.Vector;

import javax.swing.JPanel;

public abstract class AbstractListTabPanel<T> extends JPanel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected abstract Vector<String> createColumns();
}
