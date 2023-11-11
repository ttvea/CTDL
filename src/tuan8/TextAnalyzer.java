package tuan8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalyzer {
	
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException {
		
		int index=1;
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		while (true) {
			line = reader.readLine();
			
			if (line == null)
				break;
			StringTokenizer tokens = new StringTokenizer(line, " ");//tach cac tu trong dong bang dau cach
			
			while (tokens.hasMoreTokens()) {
				String word=tokens.nextToken();
				if(!tokens.hasMoreElements()) {
					add(word, -index);
				}else {
					add(word, index);
				}
				index++;
			}
			
		}
		reader.close();
	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		ArrayList<Integer>list= new ArrayList<>();
		list.add(position);
		if(!map.containsKey(word)) {
			map.put(word, list);
		}else {
			list.addAll(map.get(word));
			map.put(word, list);
		}
	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		
		TreeMap<String,List<Integer>>tree=new TreeMap<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		}
		);
		tree.putAll(map);
		for(String k:tree.keySet()) {
			System.out.println(k+"\t"+tree.get(k));
		}
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		TreeMap<Integer,String>treeMap=new TreeMap<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Math.abs(o1)-Math.abs(o2);
			}
		});
		for(String k:map.keySet()) {
			for(int i:map.get(k)) {
				treeMap.put(i,k);
			}
		}
		for(Integer k:treeMap.keySet()) {
			System.out.print(treeMap.get(k)+"\t");
			if(k<0) {
				System.out.println();
			}
		}
	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		// TODO
		int maxSize=0;
		String max="";
		for(String k:map.keySet()) {
			for(int i:map.get(k)) {
				if(map.get(k).size()>maxSize) {
					maxSize=map.get(k).size();
					max=k;
				}
				
			}
		}
		return max;
	}
	public static void main(String[] args) throws IOException {
		TextAnalyzer t1=new TextAnalyzer();
		t1.load("data/short.txt");
//		System.out.println(t1.map);
//		t1.displayWords();
		t1.displayText();
		System.out.println(t1.mostFrequentWord());
	}

}
