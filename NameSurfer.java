/*  Student information for assignment:
 *
 *  On my honor, <Matthew Trahan>, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: mt28529
 *  email address: mtrahan920@sbcglobal.net
 *  Grader name: Eric
 *  Number of slip days I am using: 0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

public class NameSurfer {

	// constants for menu choices
	public static final int SEARCH = 1;
	public static final int ONE_NAME = 2;
	public static final int APPEAR_ONCE = 3;
	public static final int APPEAR_ALWAYS = 4;
	public static final int MORE_POPULAR = 5;
	public static final int LESS_POPULAR = 6;
	public static final int ROLLERCOASTER = 7;
	public static final int QUIT = 8;
	
	// CS314 students, explain your menu option 7 here:
	// My menu option 7 shows any names that gain popularity then lose it just to gain it back and
	// lose it again over and over. There are no names that do it in the text files but I made a
	// test case that shows it works.
	
	
	// CS314 students, Explain your interesting search / trend here:
	// I noticed that variations on names, for example Kelsey to Kelsi, started to appear in the 1970s, while
	// really taking off in the 1980s and continued to do well through the 2000s in some cases. 
	// This is an interesting thing and my best guess would be that more and more performers and artists
	// began to use names like these resulting in the American people to follow.
	
	// CS314 students, add test code for NameRecord class here:
	public static void testMethod() {
		NameRecord a1 = new NameRecord("Matthew 168 159 180 225 205 100 36 10 3 3 3", 1900);
		NameRecord a2 = new NameRecord("Bob 443 345 138 89 122 225 199 583 947 0 0", 1900);
		NameRecord a3 = new NameRecord("Billy 1000 999 998 997 996 995 994 993 992 991 0", 1900);
		NameRecord a4 = new NameRecord("Casey 1 2 3 4 5 6 7 8 9 10 0", 1900);
		NameRecord a5 = new NameRecord("Hank 0 5 15 25 35 45 55 65 75 84 99", 1900);
		NameRecord a6 = new NameRecord("Bobby 0 999 998 997 996 995 994 993 992 991 990", 1900);
		NameRecord a7 = new NameRecord("Rick 0 0 0 0 0 6 0 0 0 0 0", 1900);
		NameRecord a8 = new NameRecord("Smith 1 2 3 4 5 6 6 8 9 10 11", 1900);
		NameRecord a9 = new NameRecord("Keith 0 0 0 4 5 0 6 8 9 10 11", 1930);
		NameRecord a10 = new NameRecord("Steve 0 1 900 800 950 750 800 600 700 333 0", 1900);
		// test 1
		if(a1.getName().equals("Matthew"))
			System.out.println("Passed Test 1");
		else
			System.out.println("*****FAILED TEST 1*****");
		// test 2
		if(a2.getName().equals("Bob"))
			System.out.println("Passed Test 2");
		else
			System.out.println("*****FAILED TEST 2*****");
		// test 3
		if(a1.baseDecade() == 1900)
			System.out.println("Passed Test 3");
		else
			System.out.println("*****FAILED TEST 3*****");
		// test 4
		if(a9.baseDecade() == 1930)
			System.out.println("Passed Test 4");
		else
			System.out.println("*****FAILED TEST 4*****");
		// test 5
		if(a1.getRank(5) == 100)
			System.out.println("Passed Test 5");
		else
			System.out.println("*****FAILED TEST 5*****");
		// test 6
		if(a4.getRank(10) == 0)
			System.out.println("Passed Test 6");
		else
			System.out.println("*****FAILED TEST 6*****");
		// test 7
		if(a1.getBestDecade() == 2000)
			System.out.println("Passed Test 7");
		else
			System.out.println("*****FAILED TEST 7*****");
		// test 8
		if (a8.getBestDecade() == 1900)
			System.out.println("Passed Test 8");
		else
			System.out.println("*****FAILED TEST 8*****");
		// test 9
		if (a6.numTimesRanked() == 10)
			System.out.println("Passed Test 9");
		else
			System.out.println("*****FAILED TEST 9*****");
		// test 10
		if (a9.numTimesRanked() == 7)
			System.out.println("Passed Test 10");
		else
			System.out.println("*****FAILED TEST 10*****");
		// test 11
		if (a6.rankedEveryDecade() == false)
			System.out.println("Passed Test 11");
		else
			System.out.println("*****FAILED TEST 11*****");
		// test 12
		if (a1.rankedEveryDecade() == true)
			System.out.println("Passed Test 12");
		else
			System.out.println("*****FAILED TEST 12*****");
		// test 13
		if (a7.rankedOnce() == true)
			System.out.println("Passed Test 13");
		else
			System.out.println("*****FAILED TEST 13*****");
		// test 14
		if (a3.rankedOnce() == false)
			System.out.println("Passed Test 14");
		else
			System.out.println("*****FAILED TEST 14*****");
		// test 15
		if (a3.gainingPopularity() == false)
			System.out.println("Passed Test 15");
		else
			System.out.println("*****FAILED TEST 15*****");
		// test 16
		if (a6.gainingPopularity() == true)
			System.out.println("Passed Test 16");
		else
			System.out.println("*****FAILED TEST 16*****");
		// test 17
		if (a4.gainingPopularity() == false)
			System.out.println("Passed Test 17");
		else
			System.out.println("*****FAILED TEST 17*****");
		// test 18
		if (a4.losingPopularity() == true)
			System.out.println("Passed Test 18");
		else
			System.out.println("*****FAILED TEST 18*****");
		// test 19
		if (a3.losingPopularity() == false)
			System.out.println("Passed Test 19");
		else
			System.out.println("*****FAILED TEST 19*****");
		// test 20
		if (a5.losingPopularity() == false)
			System.out.println("Passed Test 20");
		else
			System.out.println("*****FAILED TEST 20*****");
		// test 21
		if (a1.toString().equals("Matthew\n1900: 168\n1910: 159\n1920: 180\n1930: 225\n1940: 205\n1950: 100\n1960: 36\n1970: 10\n1980: 3\n1990: 3\n2000: 3\n"))
			System.out.println("Passed Test 21");
		else
			System.out.println("*****FAILED TEST 21*****");
		// test 22
		if (a4.toString().equals("Casey\n1900: 1\n1910: 2\n1920: 3\n1930: 4\n1940: 5\n1950: 6\n1960: 7\n1970: 8\n1980: 9\n1990: 10\n2000: 0\n"))
			System.out.println("Passed Test 22");
		else
			System.out.println("*****FAILED TEST 22*****");
		// test 23 for own method
		if (a10.upAndDownPopularity() == true)
			System.out.println("Passed Test 23");
		else
			System.out.println("*****FAILED TEST 23*****");
		
	}
	
    // simple test for toString
    public static void simpleToStringTest() {
        // raw data for Jake. Alter as necessary for your NameRecord
        String jakeRawData = "Jake 262 312 323 479 484 630 751 453 225 117 97";
        int baseDecade = 1900;
        NameRecord jakeRecord = new NameRecord(jakeRawData, baseDecade); // complete with your constructor
        String expected = "Jake\n1900: 262\n1910: 312\n1920: 323\n1930: 479\n1940: 484\n1950: 630\n1960: 751\n1970: 453\n1980: 225\n1990: 117\n2000: 97\n";
        String actual = jakeRecord.toString();
        System.out.println("expected string:\n" + expected);
        System.out.println("actual string:\n" + actual);
        if(expected.equals(actual))
            System.out.println("passed Jake toString test.");
        else
            System.out.println("FAILED Jake toString test.");  
    }
	
	// main method. Driver for the whole program
	public static void main(String[] args) {
		// testMethod();
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
		    System.out.println("Unable to set look at feel to local settings. " +
		    		"Continuing with default Java look and feel.");
		}
	    try {
		    
	        // uncomment the next two lines if you want to let user obtain file via GUI
	       // System.out.println("Opening GUI to choose file with names data...");
	         //   Scanner fileScanner = new Scanner(getFile());
	        
		    
		    // uncomment next line to hard code name file
		    Scanner fileScanner = new Scanner(new File("names.txt"));
			Names n = new Names(fileScanner);
			fileScanner.close();
			int choice;
			Scanner keyboard = new Scanner(System.in);
			do {
				showMenu();
				choice = getChoice(keyboard);
				if( choice == SEARCH)
					search(n, keyboard);
				else if( choice == ONE_NAME )
					oneName(n, keyboard);
				else if( choice == APPEAR_ONCE )
					appearOnce(n);
				else if( choice == APPEAR_ALWAYS )
					appearAlways(n);
				// CS314 students, complete this section
				else if( choice == MORE_POPULAR)
					morePopular(n);
				else if( choice == LESS_POPULAR)
					lessPopular(n);
				else if( choice == ROLLERCOASTER)
					rollercoasterPopularity(n);
				else
					System.out.println("\n\nGoodbye.");

			} while( choice != QUIT);
		}
		catch(FileNotFoundException e) {
			System.out.println("Problem reading the data file. Exiting the program." + e);
		}
	}
	
	// method that shows all names that contain a substring from the user
	// and the decade they were most popular in
	// pre: n != null, keyboard != null and is connected to System.in
	// post: show the correct data
	private static void search(Names n, Scanner keyboard) {
		System.out.print("Enter a partial name: ");
		String input = keyboard.nextLine();
		ArrayList<NameRecord> result = n.getMatches(input);
		System.out.println();
		System.out.println("There are " + result.size() + " matches for " + input + ".");
		if(result.size() != 0) {
			System.out.println();
			System.out.println("The matches with their highest ranking decade are:");
			for(NameRecord iterate : result)
				System.out.println(iterate.getName() + " " + (iterate.getBestDecade()));
		}
	}
	
	// method that shows data for one name, or states that name has never been ranked
	// pre: n != null, keyboard != null and is connected to System.in
	// post: print out the data for n or a message that n has never been in the top 1000 for any decade
	private static void oneName(Names n, Scanner keyboard) {
		if(n == null || keyboard == null)
			throw new IllegalArgumentException("Please follow preconditions: n and keyboard may not be null.");
		System.out.print("Enter a name: ");
		String input = keyboard.nextLine();
		NameRecord name = n.dataForOneName(input);
		if(name == null)
			System.out.println("\n" + input + " does not appear in any decade.");
		else
			System.out.println("\n" + name.toString());
	}
	
	// method that shows names that have appeared in only one decade
	// pre: n != null
	// post: print out names that have appeared in only one decade
	private static void appearOnce(Names n) {
		if(n == null)
			throw new IllegalArgumentException("Please follow preconditions: n may not be null.");
		ArrayList<String> namesAO = n.rankedOnlyOneDecade();
		System.out.println(namesAO.size() + " names appear in exactly one decade. The names are: ");
		// again, for each is good since we are iterating through entire arraylist
		for(String iterate : namesAO)
			System.out.println(iterate);
	}
	
	// method that shows names that have appeared in ever decade
	// pre: n != null
	// post: print out names that have appeared in ever decade
	private static void appearAlways(Names n) {
		if(n == null)
			throw new IllegalArgumentException("Please follow preconditions: n may not be null.");
		ArrayList<String> namesRED = n.rankedEveryDecade();
		System.out.println(namesRED.size() + " names appear in every decade. The names are: ");
		for(String data: namesRED)
			System.out.println(data);
	}
	
	// show names that gain popularity in every decade
	private static void morePopular(Names n) {
		if(n == null)
			throw new IllegalArgumentException("Please follow preconditions: n may not be null.");
		ArrayList<String> namesMP = n.alwaysMorePopular();
		System.out.println(namesMP.size() + " names are more popular in every decade. ");
		for(String iterate : namesMP)
			System.out.println(iterate);
		System.out.println();
	}
	
	// show names that lose popularity in every decade
	private static void lessPopular(Names n) {
		if(n == null)
			throw new IllegalArgumentException("Please follow preconditions: n may not be null.");
		ArrayList<String> namesLP = n.alwaysLessPopular();
		System.out.println(namesLP.size() + " names are less popular in every decade. ");
		for(String iterate : namesLP)
			System.out.println(iterate);
	}
	
	// return the names that have popularity that goes up then down then up starting with the first rank
	private static void rollercoasterPopularity(Names n) {
		if(n == null)
			throw new IllegalArgumentException("Please follow preconditions: n may not be null.");
		ArrayList<String> namesRCP = n.rollercoasterPop();
		System.out.println(namesRCP.size() + " names have an up and down trend in every decade. ");
		for(String iterate : namesRCP)
			System.out.println(iterate);
	}

	// get choice from the user
	// keyboard != null and is connected to System.in
	// return an int that is >= SEARCH and <= QUIT
	private static int getChoice(Scanner keyboard) {
		int choice = getInt(keyboard, "Enter choice: ");
		keyboard.nextLine();
		while( choice < SEARCH || choice > QUIT){
			System.out.println("\n" + choice + " is not a valid choice");
			choice = getInt(keyboard, "Enter choice: ");
			keyboard.nextLine();
		}
		return choice;
	}
	
	// ensure an int is entered from the keyboard
	// pre: s != null and is connected to System.in
    private static int getInt(Scanner s, String prompt) {
        System.out.print(prompt);
        while( !s.hasNextInt() ){
            s.next();
            System.out.println("That was not an int.");
            System.out.print(prompt);
        }
        return s.nextInt();
    }

    // show the user the menu
	private static void showMenu() {
		System.out.println("\nOptions:");
		System.out.println("Enter " + SEARCH + " to search for names.");
		System.out.println("Enter " + ONE_NAME + " to display data for one name.");
		System.out.println("Enter " + APPEAR_ONCE+ " to display all names that appear in only one decade.");
		System.out.println("Enter " + APPEAR_ALWAYS + " to display all names that appear in all decades.");
		// CS314 students fill in other options
		System.out.println("Enter " + MORE_POPULAR + " to display all names that are more popular in every decade.");
		System.out.println("Enter " + LESS_POPULAR + " to display all names that are less popular in every decade.");
		System.out.println("Enter " + ROLLERCOASTER + " to display the names that gain popularity then lose popularity continuously.");
		System.out.println("Enter " + QUIT + " to quit.\n");
	}

	/** Method to choose a file using a traditional window.
     * @return the file chosen by the user. Returns null if no file picked.
     */ 
    public static File getFile() {
        // create a GUI window to pick the text to evaluate
        JFileChooser chooser = new JFileChooser(".");
        chooser.setDialogTitle("Select File With Baby Names Data.");
        int retval = chooser.showOpenDialog(null);
        File f =null;
        chooser.grabFocus();
        if (retval == JFileChooser.APPROVE_OPTION)
           f = chooser.getSelectedFile();
        return f;
    }

}