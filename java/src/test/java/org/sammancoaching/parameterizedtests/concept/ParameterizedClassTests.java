package org.sammancoaching.parameterizedtests.concept;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.Parameter;
import org.junit.jupiter.params.ParameterizedClass;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
