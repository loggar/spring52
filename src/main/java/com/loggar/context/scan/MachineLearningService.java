package com.loggar.context.scan;

import org.springframework.stereotype.Service;

@Service("ml")
public class MachineLearningService implements DataModelService {

	@Override
	public boolean isValid(String input) {
		return true;
	}

}
