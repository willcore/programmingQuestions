
import java.util.ArrayList;
import java.util.Scanner;

public class palindromeSizes {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String curr;
		ArrayList<Integer> ans = new ArrayList<>();
		
		
		for(int i =0; i<n; i++){
			
			int numPair = 0;
			ArrayList<Character> alph = new ArrayList<>();
			
			curr = in.next();
			int len = curr.length();

			
			for(int m = 0; m<len; m++){
				//only adding letters it hasn't seen before
				if(!alph.contains(curr.charAt(m)))
					alph.add(curr.charAt(m));
				else{
					numPair++;
					alph.remove(alph.indexOf(curr.charAt(m)));
					}
				
			}
			
			
			int numPalin = 0;
			
			if(len == (2*numPair))
				numPalin = len;
			else
				numPalin = (2*numPair)+1;
		
			ans.add(numPalin);
		}
		
		for(int i=0; i<ans.size(); i++){
			
			System.out.println(ans.get(i));
		}
		
	}

}

