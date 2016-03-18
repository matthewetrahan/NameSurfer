import java.util.ArrayList;

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

public class NameRecord implements Comparable<NameRecord> {
	
	private ArrayList<Integer> nameRanks;
	private String name;
	private int startingDecade;
	
	// constructor for namerecord
	public NameRecord(String data, int baseDecade) {
		startingDecade = baseDecade;
		nameRanks = new ArrayList<Integer>();
		String[] parsedData = data.split("\\s+");
		name = parsedData[0];
		for (int i = 1; i < parsedData.length; i++)
			nameRanks.add(Integer.parseInt(parsedData[i]));
	}
	
	// simply return the name that we made in the constructor
	public String getName() {
		return name;
	}
	
	// a method to return the first decade rank
	public int baseDecade() {
		return startingDecade;
	}
	
	// get the rank of a given decade
	public int getRank(int decade) {
		return nameRanks.get(decade);
	}
	
	// return the namerecord's best decade. loop backwards since most recent year returned
	public int getBestDecade() {
		int bestRanking = 1001;
		int bestDecade = 0;
		for(int i = 0; i < size(); i++)
			if(nameRanks.get(i) <= bestRanking && nameRanks.get(i) != 0) {
				bestDecade = i;
				bestRanking = nameRanks.get(i);
			}
		return startingDecade + bestDecade * 10;
				
	} 
	
	// return the number of decades name has been ranked in top 1000
	public int numTimesRanked() {
		int numRanked = 0;
		for(int i = 0; i < nameRanks.size(); i++)
			if(nameRanks.get(i) <= 1000 && nameRanks.get(i) != 0)
				numRanked++;
		return numRanked;
	}
	
	// return true if the name is ranked in every decade
	public boolean rankedEveryDecade() {
		return numTimesRanked() == nameRanks.size();
	}
	
	// return true if name is ranked only once
	public boolean rankedOnce() {
		return numTimesRanked() == 1;
	}
	
	// return true if each decade, the next rank is greater than the previous
	public boolean gainingPopularity() {
		// none will be greater than 1002 so its a good num to use
		int previousDecade = 1002;
		for(int i = 0; i < nameRanks.size(); i++) {
			// to easily compare, if it is 0 then set it to 1001 since to gain popularity, it has to be
			// larger than 1001 ie at least 999
			if(nameRanks.get(i) == 0)
				nameRanks.set(i, 1001);
			if(nameRanks.get(i) < previousDecade)
				previousDecade = nameRanks.get(i);
			else
				return false;
			// backtrack over our quick fix
			if(nameRanks.get(i) == 1001)
				nameRanks.set(i, 0);
		}
		// if it passed the for loop, it must be true
		return true;
	}
	
	// opposite of above method, name loses popularity consecutively
	public boolean losingPopularity() {
		// none will be less than 0 so its a good num to use
				int previousDecade = 0;
				for(int i = 0; i < nameRanks.size(); i++) {
					// to easily compare, if it is 0 then set it to 1001
					if(nameRanks.get(i) == 0)
						nameRanks.set(i, 1001);
					if(nameRanks.get(i) > previousDecade)
						previousDecade = nameRanks.get(i);
					else
						return false;
					// backtrack over our quick fix
					if(nameRanks.get(i) == 1001)
						nameRanks.set(i, 0);
				}
				// if it passed the for loop, it must be true
				return true;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(name + "\n");
		for(int i = 0; i < nameRanks.size(); i++)
			sb.append((startingDecade + i * 10) + ": " + nameRanks.get(i) + "\n");
		return sb.toString();
	}
	
	// size method to help out other methods
	public int size() {
		return nameRanks.size();
	}
	
    // implement a compareTo method to use Collections to make sorting easy
    public int compareTo(NameRecord other) {
        return name.compareTo(other.name);
    }

    // to implement the method in names that implements the method in namesurfer
	public boolean upAndDownPopularity() {
		int previousDecade = 0;
		for(int i = 0; i < nameRanks.size(); i++) {
			if(nameRanks.get(i) == 0)
				nameRanks.set(i, 1001);
			if(i % 2 == 0 && nameRanks.get(i) > previousDecade)
				previousDecade = nameRanks.get(i);
			else if(i % 2 == 1 && nameRanks.get(i) < previousDecade)
				previousDecade = nameRanks.get(i);
			else
				return false;
			if(nameRanks.get(i) == 1001)
				nameRanks.set(i, 0);
		}
		return true;
	}
	
}
