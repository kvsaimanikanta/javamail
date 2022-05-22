package com.springmvc.lc.propertyeditor;

import java.beans.PropertyEditorSupport;

public class CrushNamePopertyEditor extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub

		String s1 = text.substring(0, 1).toUpperCase();

		setValue(s1+text.substring(1));
	}

	
}
