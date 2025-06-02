package org.sammancoaching.parameterizedtests.concept;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class PrimeNumberUpTo1000Generator implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
		return IntStream.range(0, 1000).filter(i -> isPrime(i)).mapToObj(Arguments::of);
	}

	public static boolean isPrime(int number) {
		return number > 2 && IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
	}

}
