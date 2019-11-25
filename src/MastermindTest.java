import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class collects all of the test methods for our controller.
 * 
 * In eclipse, running it should run it under JUnit. Running the Mastermind class (since
 * it is our main class) will actually run the program. If you're not using eclipse,
 * you'll need to run this under JUnit 5. 
 * 
 * @author Lauren Olson
 *
 */
class MastermindTest {

	/**
	 * Test method for {@link MastermindController#isCorrect(java.lang.String)}.
	 */
	@Test
	void testIsCorrect() {
		//Build a model with a known answer, using our special testing constructor
		MastermindModel answer = new MastermindModel("rrrr");
		//Build the controller from the model
		MastermindController controllerUnderTest = new MastermindController(answer);
		
		//For a properly working controller, this should return true
		try {
			assertTrue(controllerUnderTest.isCorrect("rrrr"));
		}
		catch(MastermindIllegalColorException color) {
			System.err.println("illegal color");
		}
		catch(MastermindIllegalLengthException length) {
			System.err.println("illegal color");
		}
		//For a properly working controller, this should be false
		try {
			assertFalse(controllerUnderTest.isCorrect("oooo"));
		}
		catch(MastermindIllegalColorException color) {
			System.err.println("illegal color");
		}
		catch(MastermindIllegalLengthException length) {
			System.err.println("illegal color");
		}
		
		
		//Make as many more assertions as you feel you need to test the MastermindController.isCorrect method
	}

	/**
	 * Test method for {@link MastermindController#getRightColorRightPlace(java.lang.String)}.
	 */
	@Test
	void testGetRightColorRightPlace() {
		//Build a model with a known answer, using our special testing constructor
		MastermindModel answer = new MastermindModel("rrrr");
		//Build the controller from the model
		MastermindController controllerUnderTest = new MastermindController(answer);
		
		//For a properly working controller, this should return 4
		assertEquals(controllerUnderTest.getRightColorRightPlace("rrrr"), 4);
		
		//For a properly working controller, this should return 0
		assertEquals(controllerUnderTest.getRightColorRightPlace("oooo"), 0);
		
		//You'll need lots more of these to convince yourself your implementation is right
	}

	/**
	 * Test method for {@link MastermindController#getRightColorWrongPlace(java.lang.String)}.
	 */
	@Test
	void testGetRightColorWrongPlace() {
		//TODO this one you're all on your own 
		MastermindModel answer = new MastermindModel("oror");
		//Build the controller from the model
		MastermindController controllerUnderTest = new MastermindController(answer);
		
		//For a properly working controller, this should return 0
		assertEquals(controllerUnderTest.getRightColorRightPlace("oooo"), 2);
		assertEquals(controllerUnderTest.getRightColorWrongPlace("oooo"), 0);
		
		//for a properly working controller, this should return 4
		assertEquals(controllerUnderTest.getRightColorRightPlace("roro"), 0);
		assertEquals(controllerUnderTest.getRightColorWrongPlace("roro"), 4);
		
		//For a properly working controller, this should return 0
		assertEquals(controllerUnderTest.getRightColorRightPlace("oooo"), 2);
		assertEquals(controllerUnderTest.getRightColorWrongPlace("oooo"), 0);
		
		answer = new MastermindModel("rrrr");
		//Build the controller from the model
		controllerUnderTest = new MastermindController(answer);
		
		//for a properly working controller, this should return 4
		assertEquals(controllerUnderTest.getRightColorRightPlace("rrrr"), 4);
		assertEquals(controllerUnderTest.getRightColorWrongPlace("rrrr"), 0);
		
		//for a properly working controller, this should return 4
		assertEquals(controllerUnderTest.getRightColorRightPlace("oooo"), 0);
		assertEquals(controllerUnderTest.getRightColorWrongPlace("oooo"), 0);
		
		//for a properly working controller, this should return 4
		assertEquals(controllerUnderTest.getRightColorRightPlace("roro"), 2);
		assertEquals(controllerUnderTest.getRightColorWrongPlace("roro"), 0);

	}
	/**
	 * Test method for {@link MastermindController#throwColor(java.lang.String)}.
	 */
	@Test
	void throwColor() {
		//TODO this one you're all on your own 
		MastermindModel answer = new MastermindModel("oror");
		//Build the controller from the model
		MastermindController controllerUnderTest = new MastermindController(answer);
		
		//For a properly working controller, this should return 0
		assertThrows(MastermindIllegalColorException.class, () -> {controllerUnderTest.isCorrect("aaaa");});
		assertThrows(MastermindIllegalColorException.class, () -> {controllerUnderTest.isCorrect("");});
		


	}
	/**
	 * Test method for {@link MastermindController#throwLength(java.lang.String)}.
	 */
	@Test
	void throwLength() {
		//TODO this one you're all on your own 
		MastermindModel answer = new MastermindModel("oror");
		//Build the controller from the model
		MastermindController controllerUnderTest = new MastermindController(answer);
		
		//For a properly working controller, this should return 0
		assertThrows(MastermindIllegalLengthException.class, () -> {controllerUnderTest.isCorrect("rororoorororo");});
		assertThrows(MastermindIllegalLengthException.class, () -> {controllerUnderTest.isCorrect("o");});
		


	}

}