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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * A collection of NameRecords. 
 * Stores NameRecord objects and provides methods to select
 * NameRecords based on various criteria.
 */
public class Names {
	
	private ArrayList<NameRecord> names;
	private int baseDecade;
	private int numberOfDecades;
	
	// the file contains the base decade in the first line, number of decades in the next
	public Names(Scanner fileScanner) {
//		String line;
//		baseDecade = fileScanner.nextInt();
//		numberOfDecades = fileScanner.nextInt();
//		while( fileScanner.hasNextLine() )
//		{
//		line = fileScanner.nextLine();
//		/* create a NameRecord object based on line and add it to the ArrayList of NameRecord objects */
//		NameRecord temp = new NameRecord(line, baseDecade);
//		names.add(temp);
//		}
		names = new ArrayList<NameRecord>();
		baseDecade = fileScanner.nextInt();
		numberOfDecades = fileScanner.nextInt();
		String line = "";
		while(fileScanner.hasNextLine()) {
			line = fileScanner.nextLine();
			NameRecord records = new NameRecord(line, baseDecade);
			if(records.size() == numberOfDecades)
				names.add(records);
		}
	}
	
	// return a name record whose name is equal to a given String ignoring case
	// return null if none match. Since we're essentially just going through the whole
	// ArrayList of NameRecord's, a for each loop will work well with all following methods
	public NameRecord ignoreCase(String inputtedName) {
		for(NameRecord possibleMatch : names)
			if(possibleMatch.getName().equalsIgnoreCase(inputtedName))
				return possibleMatch;
		return null;
	}

    /**
     * Returns an ArrayList of NameRecord objects that contain a 
     * given substring, ignoring case.  The names must be in sorted order based 
     * on name.
     * @param partialName != null, partialName.length() > 0
     * @return an ArrayList of NameRecords whose names contains
     * partialName. If there are no NameRecords that meet this
     * criteria returns an empty list. 
     */
    
    public ArrayList<NameRecord> getMatches(String partialName) {
    	if (partialName == null || partialName.length() == 0)
    		throw new IllegalArgumentException("Please follow preconditions: partialName != null, partialName.length() > 0");
    	ArrayList<NameRecord> result = new ArrayList<NameRecord>();
    	String compare = partialName.toUpperCase();
    	for(int i = 0; i < names.size(); i++) {
    		NameRecord getRecords = names.get(i);
    		String getName = getRecords.getName();
    		// set the name received from the get method to upper case to compare to partial name also upper case
    		if(getName.toUpperCase().contains(compare))
    				result.add(getRecords);
    	}
    	Collections.sort(result);
    	return result;
    }

    /**
     * Returns an ArrayList of Strings of names that have been ranked in the
     * top 1000 or better for every decade. The Strings  must be in sorted 
     * order based on name. 
     * @return A list of the names that have been ranked in the top
     * 1000 or better in every decade. The list is in sorted ascending
     * order. If there are no NameRecords that meet this
     * criteria returns an empty list.
     */
    
    public ArrayList<String> rankedEveryDecade() {
    	ArrayList<String> result = new ArrayList<String>();
    	for(NameRecord iterate : names)
    		if(iterate.rankedEveryDecade())
    			result.add(iterate.getName());
    	Collections.sort(result);
    	return result;
    }

    /**
     * Returns an ArrayList of Strings of names that have been ranked in the 
     * top 1000 or better in exactly one decade. The Strings must be in sorted 
     * order based on name. 
     * @return A list of the names that have been ranked in the top
     * 1000 or better in exactly one decade. The list is in sorted ascending
     * order. If there are no NameRecords that meet this
     * criteria returns an empt;y list.
     */
    public ArrayList<String> rankedOnlyOneDecade() {
    	ArrayList<String> result = new ArrayList<String>();
    	for(NameRecord iterate : names)
			if(iterate.rankedOnce())
				result.add(iterate.getName());
    	Collections.sort(result);
    	return result;
    }

    /**
     * Returns an ArrayList of Strings of names that have been getting more
     * popular every decade. The Strings  must be in sorted order based on name.
     * @return A list of the names that have been getting more popular in
     * every decade. The list is in sorted ascending
     * order. If there are no NameRecords that meet this
     * criteria returns an empty list. 
     */
    public ArrayList<String> alwaysMorePopular() {
    	ArrayList<String> result = new ArrayList<String>();
		for(NameRecord iterate : names)
			if(iterate.gainingPopularity())
				result.add(iterate.getName());
		Collections.sort(result);
		return result;
    }

    /**
     * Returns an ArrayList of Strings of names that have been getting less
     * popular every decade. The Strings  must be in sorted order based on name.
     * @return A list of the names that have been getting less popular in
     * every decade. The list is in sorted ascending
     * order. If there are no NameRecords that meet this
     * criteria returns an empty list. 
     */
    public ArrayList<String> alwaysLessPopular() {
    	ArrayList<String> result = new ArrayList<String>();
		for(NameRecord iterate : names)
			if(iterate.losingPopularity())
				result.add(iterate.getName());
		Collections.sort(result);
		return result;
    }
        
    // method to use in namesurfer, search for one name while ignoring case
    public NameRecord dataForOneName(String input) {
    	for(NameRecord iterate : names) {
			if(iterate.getName().equalsIgnoreCase(input))
				return iterate;
		}
    	// return null because method in namesurfer will take care of the rest
		return null;
    }
    
    // to implement the method in namesurfer, sort the results with collection
	public ArrayList<String> rollercoasterPop() {
		ArrayList<String> result = new ArrayList<String>();
		for(NameRecord iterate : names)
			if(iterate.upAndDownPopularity())
				result.add(iterate.getName());
		Collections.sort(result);
		return result;
	}
}