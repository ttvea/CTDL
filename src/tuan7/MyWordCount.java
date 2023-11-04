package tuan7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "C:\\Users\\Windows\\Downloads\\data\\fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Returns a set of WordCount objects that represents the number of times
	// each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		int count;
		List<WordCount> list = new ArrayList<WordCount>();
		for (String i : words) {
			count=0;
			for(String j:words) {
				if(i.equals(j)) {
					count++;
				}
			}
			WordCount wc = new WordCount(i, count);
			if(!list.contains(wc)) {
				list.add(wc);
			}
		}	
		return list;
	}
	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String>set=new HashSet<>();
		for(WordCount w:getWordCounts())
			if(w.getCount()==1) {
				set.add(w.getWord());
			}
		return set;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result // Dai hoc Nong Lam Dai Hoc ===> Dai hoc Nong Lam
	public Set<String> getDistinctWords() {
		Set<String>set=new HashSet<>(words);
		return set;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
		Set<WordCount>set=new HashSet<>(getWordCounts());
		return set;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		Set<WordCount>set=new TreeSet<>(new Comparator<WordCount>() {
			@Override
			public int compare(WordCount o1, WordCount o2) {
				if(-(o1.getCount()-o2.getCount())==0) {
					return o1.getWord().compareTo(o2.getWord());
				}
				return -(o1.getCount()-o2.getCount());// giảm dần thì để dấu trừ đằng trc
			}										//hoac la o2-o1
			
		});
		set.addAll(getWordCounts());
		return set;
	}
	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsOrderByOccurence() {
		Set<WordCount>set=new TreeSet<>(new Comparator<WordCount>() {
			@Override
			public int compare(WordCount o1, WordCount o2) {
				return o1.getWord().compareTo(o2.getWord());//mac dinh la tang dan phai khong?
			}										
			
		});
		set.addAll(getWordCounts());
		return set; }

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<WordCount> filterWords(String pattern) {
		Set<WordCount>set=new HashSet<>(getWordCounts());
		Iterator<WordCount>iter=set.iterator();
		while(iter.hasNext()) {
			if(iter.next().getWord().indexOf(pattern)==0) {
				iter.remove();
			}
		}
		return set;
	}

	public static void main(String[] args) {
		MyWordCount m1 = new MyWordCount();
		System.out.println(m1.getWordCounts());
		System.out.println(m1.getUniqueWords());
		System.out.println(m1.getDistinctWords());
		System.out.println(m1.printWordCounts());
		System.out.println(m1.exportWordCountsByOccurence());
		System.out.println(m1.exportWordCountsOrderByOccurence());
		System.out.println(m1.filterWords("D"));
	}
}
