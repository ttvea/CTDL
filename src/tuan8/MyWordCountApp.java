package tuan8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	// Load data from fileName into the above map (containing <word, its occurences>)
	// using the guide given in TestReadFile.java
	public void loadData()  {
		Scanner input;
		try {
			input = new Scanner(new File(fileName));
			
			while (input.hasNext()) {
				String word = input.next();
//				if(!map.containsKey(word)) {
//					map.put(word, count);
//				}else {
//					map.put(word,map.get(word)+1);
//				}
				map.put(word, map.getOrDefault(word,0)+1);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	// Returns the number of distinct tokens in the file data/hamlet.txt or 
//	fit.txt
	public int countDistinct(){
	return map.size();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		for(String k:map.keySet()) {
			System.out.println(k+" "+map.get(k));
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		TreeMap<String,Integer>tree=new TreeMap<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		}
		);
		tree.putAll(map);
		for(String k:tree.keySet()) {
			System.out.println(k+" "+tree.get(k));
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		MyWordCountApp m1=new MyWordCountApp();
		m1.loadData();
		System.out.println(m1.map);
		System.out.println(m1.countDistinct());
//		m1.printWordCounts();
		m1.printWordCountsAlphabet();
	}
}
