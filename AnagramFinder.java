/*
Chan Tjun Chuang Alex
alexchan@.u.nus.edu
*/

import java.util.*;

/** 
 *	This programme finds all anagram pairs out of a given list of words.
 */

public class AnagramFinder {
	public static void main(String[] args) {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		String[] wordList = new String[24];

		wordList[0] = "vase";
		wordList[1] = "bat";
		wordList[2] = "gods";
		wordList[3] = "latte";
		wordList[4] = "name";
		wordList[5] = "apres";
		wordList[6] = "spit";
		wordList[7] = "joke";
		wordList[8] = "ham";
		wordList[9] = "dog";
		wordList[10] = "act";
		wordList[11] = "tale";
		wordList[12] = "parse";
		wordList[13] = "pits";
		wordList[14] = "asper";
		wordList[15] = "tab";
		wordList[16] = "table";
		wordList[17] = "mane";
		wordList[18] = "late";
		wordList[19] = "god";
		wordList[20] = "cat";
		wordList[21] = "table";
		wordList[22] = "save";
		wordList[23] = "spare";

		for(int i = 0; i < 24; i++) {	
			String key = sortString(wordList[i]);
			//if this is the first time a String with these characters is introduced, create a new ArrayList
			if(!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			ArrayList<String> anagrams = map.get(key);
			//Add this word to the arrayList of anagrams with THIS composition of characters
			anagrams.add(wordList[i]);
		}

		for(String key : map.keySet()) {

        	ArrayList<String> anagrams = map.get(key);
			//only print if the array list has more than 1 element (ie there are anagram pairs)
        	if(anagrams.size() > 1) {
        		System.out.println("The following are anagrams of each other: ");
        		for(int i = 0; i < anagrams.size(); i++) {
        			System.out.print("" + anagrams.get(i) + " ");
        		}
				System.out.println();
        	}
    	}
	}
	
	public static String sortString(String input) 
    { 
        char tempArray[] = input.toCharArray(); 
        Arrays.sort(tempArray); 
        return new String(tempArray); 
    } 
}
