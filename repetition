import java.util.ArrayList;
import java.util.Scanner;

public class repetition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		int P = in.nextInt();
		
		ArrayList<String> finalAns = new ArrayList<String>();
						
		for(int i = 0; i < P; i++){
			
			int dataNum = in.nextInt();
			
			int repeatCount = in.nextInt();
			
			String s = in.next();
			
			finalAns.add(repeater(dataNum, repeatCount, s));
			
		}
		
		for(int i = 0; i < finalAns.size(); i++){
			System.out.println(finalAns.get(i));
		}

	}
	
	public static String repeater(int data, int r, String input){
		
		StringBuilder ans = new StringBuilder();
		
		ans.append(data + " ");
		
		for(int i = 0; i < input.length(); i++){
			for(int j = 0; j < r; j++){
				if(Character.isDigit(input.charAt(i)) || Character.isLetter(input.charAt(i)))
					ans.append(input.charAt(i));
			}
		}
		
		return ans.toString();
		
	}
}
