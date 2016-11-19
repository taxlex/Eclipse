package assignment05;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Question1 {
	public static boolean permutation1(String s1, String s2){
		if(s1 != null && s2 != null){
			return Arrays.equals(counter(s1), counter(s2));
		}
		else return false;
	}
	public static int[] counter(String s){
		//initialize array to store occurrence of each letter
		int[] intarr = new int[26];
		if(s != null){
			s = s.toLowerCase();
			for(int i = 0; i < s.length(); i++){
				//makes sure the value is a letter in ascii value
				if(s.charAt(i) >= 97 && s.charAt(i) <= 122){
					intarr[s.charAt(i)-97]++;
				}
			}
		}
		return intarr;
	}
	
	public static int count(char c, String s){
		int inc = 0;
		if(c != 0 && s != null){
			c = Character.toLowerCase(c);
			s = s.toLowerCase();
			for(int i = 0; i < s.length(); i++){
				if(s.charAt(i) == c) inc++;
			}
		}
		return inc;
	}
	
	public static boolean permutation2(String s1, String s2){
		boolean vals = true;
		if(s1 !=null && s2!=null){
			s1 = s1.toLowerCase();
			s2 = s2.toLowerCase();
			for(char c = 'a'; c <= 'z'; c++){
				if(count(c, s1) != count(c,s2)) vals = false;
			}
		}
		if(s1 == null || s2 == null) vals = false;
		return vals;
	}
	
	static class MyChCounter {
	    char c;
	    int count = 1;
	    MyChCounter(char c1) {
	        c = c1;
	    }
	    void increment() {
	        count++;
	    }
	    @Override
	    public boolean equals(Object obj) {
	        boolean retVal = false;
	        if(obj != null && getClass() == obj.getClass()) {
	            MyChCounter m = (MyChCounter)obj;
	            retVal = (c == m.c && count == m.count);
	        }
	        return retVal;
	    }        
	    @Override
	    public int hashCode() {
	        return Character.hashCode(c)*31 + Integer.hashCode(count);
	    }
	}
	
	public static boolean permutation3(String s1, String s2){
		if(s1 != null && s2 != null){
			s1 = s1.toLowerCase();
			s2 = s2.toLowerCase();
			Map<Character, MyChCounter> counter1 = new TreeMap<>();
			Map<Character, MyChCounter> counter2 = new TreeMap<>();
			
			for(int i = 0; i < s1.length(); i++){
				if(Character.isLetter(s1.charAt(i))){
					if(counter1.containsKey(s1.charAt(i))){
						counter1.get(s1.charAt(i)).increment();
					}
					else{
						counter1.put(s1.charAt(i), new MyChCounter(s1.charAt(i)));
					}
				}
			}
			
			for(int y = 0; y < s2.length(); y++){
				if(Character.isLetter(s2.charAt(y))){
					if(counter2.containsKey(s2.charAt(y))){
						counter2.get(s2.charAt(y)).increment();
					}
					else{
						counter2.put(s2.charAt(y), new MyChCounter(s2.charAt(y)));
					}
				}
			}
			return counter1.equals(counter2);
		}
		else return false;

	}
	
	public static void main(String[] args){
		String test1a = "Here's the cinema";
		String test1b = "The Iceman's here";
		System.out.println("true: " + permutation1(test1a, test1b));
		String test2a = null;
		String test2b = "Hello";
		System.out.println("false: " + permutation1(test2a,test2b));
		String test3a = "";
		String test3b = "";
		System.out.println("true: " + permutation1(test3a, test3b));
		
		System.out.println("====================================================");
		
		String test4a = "Here's the cinema";
		String test4b = "The Iceman's here";
		System.out.println("true: " + permutation2(test4a, test4b));
		String test5a = null;
		String test5b = "Hello";
		System.out.println("false: " + permutation2(test5a,test5b));
		String test6a = "";
		String test6b = "";
		System.out.println("true: " + permutation2(test6a, test6b));
		
		System.out.println("====================================================");
		
		String test7a = "Here's the cinema";
		String test7b = "The Iceman's here";
		System.out.println("true: " + permutation3(test7a, test7b));
		String test8a = null;
		String test8b = "Hello";
		System.out.println("false: " + permutation3(test8a,test8b));
		String test9a = "";
		String test9b = "";
		System.out.println("true: " + permutation3(test9a, test9b));
	}

}
