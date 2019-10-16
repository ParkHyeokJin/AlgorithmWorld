package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_7568 {
	public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
        	int N = Integer.parseInt(reader.readLine());
        	String[] members = new String[N];
        	for(int i = 0; i < N; i++) {
        		members[i] = reader.readLine();
        	}
        	//등급 배열 생성
        	int[] grade = grade(members);
        	//출력
        	print(grade);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

	//등급
	private static int[] grade(String[] members) {
		int[] grade = new int[members.length];
		for(int i = 0; i < members.length; i++) {
			String[] member = members[i].split(" ");
			int weight = Integer.parseInt(member[0]);
			int height = Integer.parseInt(member[1]);
			
			grade[i] = compare(members, weight, height);
		}
		return grade;
	}

	//덩치 비교
	private static int compare(String[] members, int weightA, int heightA) {
		int cnt = 1;
		for (int j = 0; j < members.length; j++) {
			String[] tmpMember = members[j].split(" ");
			int weightB = Integer.parseInt(tmpMember[0]);
			int heightB = Integer.parseInt(tmpMember[1]);	
			if(weightA < weightB && heightA < heightB) {
				cnt++;
			}
		}
		return cnt;
	}
	
	private static void print(int[] grade) {
		for(int i = 0; i < grade.length; i++) {
			System.out.print(grade[i]);
			System.out.print(" ");
		}
	}
}
