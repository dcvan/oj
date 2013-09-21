import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int caseNum = 0;
		while (in.hasNext()){
			caseNum ++;
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			int d = in.nextInt();

			if (a == -1)
				break;
			
			int p = a - 21252;
			while ((p - a) % 23 != 0 || (p - b) % 28 != 0 || (p - c) % 33 != 0 || p <= d)
				p += 23;

			System.out.println("Case " + caseNum + ": the next triple peak occurs in " + (p - d) + " days.");		
		}
	}
}