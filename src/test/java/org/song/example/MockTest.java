package org.song.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ AFinalClass.class, AStaticClass.class })
public class MockTest {

	@Test
	public void mockFinalClassTest() {
		AFinalClass tested = PowerMockito.mock(AFinalClass.class);

		final String testInput = "A test input";
		final String mockedResult = "Mocked final echo result - " + testInput;
		Mockito.when(tested.echoString(testInput)).thenReturn(mockedResult);

		// Assert the mocked result is returned from method call
		Assert.assertEquals(tested.echoString(testInput), mockedResult);
	}

	@Test
	public void mockStaticClassTest() {
		PowerMockito.mockStatic(AStaticClass.class);

		final String testInput = "A test input";
		final String mockedResult = "Mocked static echo result - " + testInput;
		Mockito.when(AStaticClass.echoString(testInput)).thenReturn(mockedResult);

		// Assert the mocked result is returned from method call
		Assert.assertEquals(AStaticClass.echoString(testInput), mockedResult);
	}

	/*
	 * For TestNG test class needs to extend PowerMockTestCase This is not the case for JUnit
	 */
//	In the test programs, it is not uncommon that some test cases have final or static methods to mock,
//	while the others do not. It is important that we do not extend the "PowerMockTestCase" class
//	if the test cases do not have final or static methods to mock. TestNG will use different object factory
//	to create the test case instances in the two cases. If we extend the "PowerMockTestCase" class when
//	there is no final nor static methods to work with, the unit tests will not run consistently under Surefire in Maven.
//  see powermockito-testing MockTest.java
}
