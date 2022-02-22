package P_1837_암호제작;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static char [] p;
	static int k;
	static boolean [] isNotPrime;
	static boolean isGood;
	static ArrayList<Integer> prime;
	static int MAX = 10000000;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("정수론/P_1837_암호제작/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		p = st.nextToken().toCharArray();
		k = Integer.parseInt(st.nextToken());
		prime = new ArrayList();
		
		isNotPrime = new boolean[MAX+1];
		
		isGood = true;
		
		for(int i = 2;i<=MAX;i++) {
			
			if(isNotPrime[i] == false) {
				prime.add(i);
				for(int j = i*2;j<=MAX;j+=i) {
					isNotPrime[j] = true;
				}
			}
			
		}
	
		
		for(int num : prime) {
			
			if(num >= k) {
				System.out.println("GOOD");
				break;
			}
			
			if(isBad(num)) {
				System.out.println("BAD " + num);
				break;
			}
			
			
		}
	
		
		
		
	}
	
	static boolean isBad(int num) {
		
		int r=  0;
		
		for(int i = 0;i<p.length;i++) {
			r = (r*10 + (p[i]-'0')) % num;
		}
		
		if(r == 0) return true;
		else return false;
		
		
		
	}
}
