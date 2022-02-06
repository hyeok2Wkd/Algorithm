package P_1202_보석도둑;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Jewelry implements Comparable<Jewelry>{
	int weight;
	int price;
	public Jewelry(int weight, int price) {
		super();
		this.weight = weight;
		this.price = price;
	}
	@Override
	public int compareTo(Jewelry o) {
		// TODO Auto-generated method stub
		return Integer.compare(weight, o.weight);
	}
	
}

public class Main {
	
	static int N,K;
	static ArrayList<Jewelry> jewelrys;
	static int [] bags;
	
	public static void main(String [] args) throws Exception{
		System.setIn(new FileInputStream("알고리즘기초/P_1202_보석도둑/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bags = new int[K];
		jewelrys = new ArrayList();
		
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			jewelrys.add(new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		for(int i = 0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			bags[i] = Integer.parseInt(st.nextToken());
		}
		
		Collections.sort(jewelrys);
		Arrays.sort(bags);
		
		long result = 0;
		int idx = 0;
		
		PriorityQueue<Jewelry> pq = new PriorityQueue<>(new Comparator<Jewelry>() {

			@Override
			public int compare(Jewelry o1, Jewelry o2) {
				return Integer.compare(o2.price, o1.price);
			}
		});
		
		
		for(int i = 0;i<K;i++) {
			
			int bag = bags[i];
			
			while(idx < jewelrys.size()) {
				
				Jewelry j = jewelrys.get(idx);
				
				if(j.weight <= bag) {
					pq.add(j);
					idx++;
				}
				else {
					break;
				}
				
			}
			
			if(!pq.isEmpty()) {
				result += pq.remove().price;
			}
			
			
		}
		
		System.out.println(result);
		
		
	}
}
