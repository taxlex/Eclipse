package lab06;

public class Loops {

	public static void star_pattern_v1(int n){
		for(int i = 1; i < n+1; i++){
			for(int y = 0; y < i; y++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void star_pattern_v2(int n){
		for(int i = 0; i< n; i++){
			for(int y = 0; y < n-i; y++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	/**
	 * computes the factorial of n
	 * @param n (0,12)
	 * @return should return a positive number
	 */
	public static int slowFactorial(int n){
		if(n<0) throw new IllegalArgumentException("input cannot be negative");
		int prod = 1;
		int tmp;
		for(int i = 0; i < n; i++){
			tmp = prod;
			for(int j = 0; j < i; j++){
				prod += tmp;
			}
		}
		return prod;
	}
	public static void main(String[] args) {
		star_pattern_v1(9);
		star_pattern_v2(9);
		System.out.println(slowFactorial(15));

	}

}
