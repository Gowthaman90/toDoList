//import static org.junit.Assert.assertEquals;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.InputStream;
//import java.io.PrintStream;
//import java.text.ParseException;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//public class MenuTest {
//	Menu menuTest;
//	
//	private final InputStream systemIn = System.in;
//	private ByteArrayInputStream testIn;
//	
//	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
//	private final PrintStream originalOut = System.out;
//	private final PrintStream originalErr = System.err;
//	
//	@Before
//    public void init() {
//		menuTest = new Menu();
//		
//		System.setOut(new PrintStream(outContent));
//	    System.setErr(new PrintStream(errContent));
//    }
//	
//	@Test
//    public void printMenuTest() throws ParseException {
//	    menuTest.printMenu();
//	    
//		// Mocking to scanner input
//		String input = "6";
//		testIn = new ByteArrayInputStream(input.getBytes());
//	    System.setIn(testIn);
//	    
//        assertEquals("Invalid selection. Please try again.\n", outContent.toString());
//        
//        // Mocking to scanner input
// 		input = "4";
// 		testIn = new ByteArrayInputStream(input.getBytes());
// 	    System.setIn(testIn);
//    }
//	
//	@After
//	public void restoreStreams() {
//	    System.setOut(originalOut);
//	    System.setErr(originalErr);
//	    System.setIn(systemIn);
//	}
//
//}
