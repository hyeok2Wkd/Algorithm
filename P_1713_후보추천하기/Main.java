package P_1713_후보추천하기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Student implements Comparable<Student>{
	
	int num;
	int count;
	int time;
	boolean flag;
	
	public Student(int num) {
		this.num = num;
		this.count = 0;
		this.time = 0;
		flag = false;
	}
	
	@Override
	public int compareTo(Student o) {
		
		int comp = Integer.compare(count, o.count);
		
		if(comp != 0) {
			return comp;
		}
		else {
			int comp2 = Integer.compare(time, o.time);
			return comp2;
		}

	}
	
}

public class Main {
	
	static int n;
	static int m;
	static Student[]students;
	static ArrayList<Student> frame;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("알고리즘기초/P_1713_후보추천하기/input"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		
		students = new Student[100+1];
		frame = new ArrayList();
		
		for(int i = 1;i<101;i++) {
			
			students[i] = new Student(i);
			
		}
		
		st = new StringTokenizer(br.readLine());
		
		int cnt = 0;
		
		for(int i = 0;i<m;i++) {
			
			int num = Integer.parseInt(st.nextToken());
			
			//사진틀에있니?
			if(students[num].flag == true) {
				
				students[num].count++;
				
				
			}
			else { //사진틀에없음
				//사진틀에 자리가 있음
				if(frame.size() < n) {
					students[num].count = 1;
					students[num].flag = true;
					students[num].time = i;
					
					frame.add(students[num]);
					
				}
				else { //자리가없음
					
					Collections.sort(frame);
					
					Student temp = frame.remove(0);
					temp.count = 0;
					temp.flag = false;
					
					students[num].count = 1;
					students[num].flag = true;
					students[num].time = i;
					frame.add(students[num]);
				
				}
			}
			
			

		}
	
		
		Collections.sort(frame, new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				return Integer.compare(o1.num, o2.num);
			}
			
		});
		
		for(int i = 0;i<frame.size();i++) {
			System.out.print(frame.get(i).num+" ");
		}
		
	}
}
