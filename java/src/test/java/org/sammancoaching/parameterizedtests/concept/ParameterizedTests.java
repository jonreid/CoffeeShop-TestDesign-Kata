package org.sammancoaching.parameterizedtests.concept;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ParameterizedTests {

	@ParameterizedTest
	@ValueSource(strings = { "foo", "bar", "###", "___", "   " })
	void valueSourceWithStrings(String string) {
		// call the code to test that should do some work when getting a string
	}

	@ParameterizedTest
	@ValueSource(strings = { "foo", "bar", "###", "___", "   " })
	@NullAndEmptySource
	void valueSourceWithStringsIncludingNullAndEmptyString(String string) {
		// call the code to test that should do some work when getting a string
		// the code also should work for null or empty strings
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3, 7, 8, 9, 0, -1, -2, Integer.MIN_VALUE })
	void valueSourceWithInts(int intValue) {
		// call the code to test that should do some work when getting a value <10
	}

	private enum MyEnum {
		FOO, BAR, FOOBAR;
	}

	@ParameterizedTest
	@EnumSource
	void enumSource(MyEnum myEnum) {
		// call the code to test that should do some work when getting the enum value
	}

	private static class SomeObject {
		private SomeObject(String foo, int bar, List<SomeObject> children) {
			this.foo = foo;
			this.bar = bar;
			this.children = children;
		}

		private String foo;
		private int bar;
		private List<SomeObject> children;

		@Override
		public String toString() {
			return "Object with " + foo + "/" + bar + " and Childs " + children;
		}
		
		// here should come some code
	}

	// Collection or Stream
	private static List<SomeObject> objects() {
		SomeObject o1 = new SomeObject("foo", 42, emptyList());
		SomeObject o2 = new SomeObject("bar", 21, asList(o1));
		return asList(o1, o2);
	}

	@ParameterizedTest
	@MethodSource("objects")
	void methodSource(SomeObject someObject) {
		// call the code to test that should do some work when getting one of the
		// objects
	}

	@ParameterizedTest
	@ArgumentsSource(PrimeNumberUpTo1000Generator.class)
	void argumentSource(int primeNumber) {
		// call the code to test that should do some work when getting one of the
		// prime numbers
	}

	@ParameterizedTest
	@CsvSource({ "test,TEST", "tEst,TEST", "Java,JAVA" })
	void csvSource(String input, String expected) {
		// let's consider String#toUpperCase to be the code to test
		String actualValue = input.toUpperCase();
		assertEquals(expected, actualValue);
	}

	@ParameterizedTest
	@CsvSource(value = { //
			"test          | TEST", //
			"tEst          | TEST", //
			"Java          | JAVA", //
			"loNGER sTriNg | LONGER STRING" //
	}, delimiter = '|')
	void csvSourceWithDelimiterFormatedAndIncludingWhitespaces(String input, String expected) {
		// let's consider String#toUpperCase to be the code to test
		String actualValue = input.toUpperCase();
		assertEquals(expected, actualValue);
	}

//	// JDK15+
//	@CsvSource(delimiter = '|', textBlock = """
//			test          | TEST
//			tEst          | TEST
//			Java          | JAVA
//			loNGER sTriNg | LONGER STRING
//			""")
//	void csvSourceWithDelimiterUsingTextblock(String input, String expected) {
//		// let's consider String#toUpperCase to be the code to test
//		String actualValue = input.toUpperCase();
//		assertEquals(expected, actualValue);
//	}

	@ParameterizedTest
	// can use files and/or resources
	@CsvFileSource(resources = "/example.csv", delimiter = ';', numLinesToSkip = 1)
	void csvFileSource(String col1, String col2, int col3WithTypeConversion) {
		// let's consider String#toUpperCase to be the code to test
		String actualValue = col1.toUpperCase();
		assertThat(actualValue).isEqualTo(col2).hasSize(col3WithTypeConversion);
	}

}
