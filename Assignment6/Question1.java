package Assignment6;

public class Question1 {
	public static String name(int n) {
	      if (n >= 26*26*26*26*26*26) return "ZZZZZZ";
	      char[] chs = Integer.toString(n, 26).toCharArray();
	      char[] chs2 = new char[6];
	      System.arraycopy(chs, 0, chs2, 6-chs.length, chs.length);
	      for(int i = 0; i < 6; i++) {
	         if(chs2[i] == 0) chs2[i] = 'A';
	         if(chs2[i] >= '0' && chs2[i] <= '9') chs2[i] = (char)('A' + chs2[i]-'0');
	         if(chs2[i] >= 'a' && chs2[i] <= 'p') chs2[i] = (char)('A' + 10 + chs2[i]-'a');
	      }		
	      return new String(chs2);
	   }
	public static int nameToInt(String str){
		if(str.length() < 6 || str.length() > 6 || str == null) return -1;
		int val = 0;
		double valy = 0.0;
		for(int i = 0, j = 5; i < 6; i++, j--){
			if(str.charAt(j) < 65 || str.charAt(j) > 90) return -1;
			valy += (str.charAt(j) - 'A')*(Math.pow(26, i));
		}
		val = (int) valy;
		return val;
	}
	public static String next(String str){
		if(nameToInt(str) == -1) return null;
		int x = nameToInt(str) + 1;
		if(x == 308915776) x = 0;
		return name(x);
		
	}
	public static String previous(String str){
		if(nameToInt(str) == -1) return null;
		int x = nameToInt(str) - 1;
		if(x == -1) x = 308915775;
		return name(x);
		
	}
	   public static void main(String[] args) {
	      for(int n = 10000; n < 11000; n++) {
	         System.out.println(name(n));
	      }
	      System.out.println(name(0));
	      System.out.println(name(26*26*26*26*26*26 - 2));
	      System.out.println(name(26*26*26*26*26*26 - 1));
	      System.out.println(26*26*26*26*26*26); //308,915,776
	      //Test Cases
	      System.out.println(name(999999));
	      System.out.println("999999: " + nameToInt("ACEXHN"));
	      System.out.println("-1 too long: " + nameToInt("ABCDEFG"));
	      System.out.println("-1 empty: " + nameToInt(""));
	      System.out.println("-1 not capital letter: " + nameToInt("123456"));
	      System.out.println("-1 not capital letter: " + nameToInt("abcdef"));
	      System.out.println("AAAAAA: " + next("ZZZZZZ"));
	      System.out.println("ZZZZZZ: " + previous("AAAAAA"));
	   }
}
