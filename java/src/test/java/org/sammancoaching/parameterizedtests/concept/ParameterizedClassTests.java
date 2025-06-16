package org.sammancoaching.parameterizedtests.concept;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.Parameter;
import org.junit.jupiter.params.ParameterizedClass;
import org.junit.jupiter.params.provider.ValueSource;

@ParameterizedClass
@ValueSource(strings = { "foo", "bar", "###", "___", "   " })
class ParameterizedClassTests {

	@Parameter
	String string;

	@Test
	void checkOneOnString() {
		// call the code to test that should do some work when getting a string
	}

	@Test
	void checkTwoOnString() {
		// call other code to test that should do some work when getting a string
	}

}
