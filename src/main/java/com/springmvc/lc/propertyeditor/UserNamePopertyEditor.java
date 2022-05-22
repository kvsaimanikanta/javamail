package com.springmvc.lc.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.util.logging.Logger;

public class UserNamePopertyEditor extends PropertyEditorSupport {
	
	Logger logger = Logger.getLogger(UserNamePopertyEditor.class.getName());

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
		//try {
			String s1 = text.substring(0, 1).toUpperCase();

			setValue(s1 + text.substring(1));
//		}catch (Exception e) {
//			logger.info(">>>>>>>>>>>>>> Excepyion Occured"+e);
//		}
	}

}
