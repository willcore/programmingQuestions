import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;


public class electionResults {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		String curr;

		Hashtable<String, Integer> votes = new Hashtable<String, Integer>();
		
		for(int i=0; i<n; i++){
			curr = in.next();
			
			if(!votes.containsKey(curr)){
				votes.put(curr, 1);
			}
			else
				votes.put(curr, votes.get(curr)+1);
		}
		
		int max = 0;

		Set<String> keys = votes.keySet();
		
		for(String key : keys)
			if(votes.get(key) > max)
				max = votes.get(key);

		ArrayList<String> thePresident = new ArrayList<String>();
		
		for(String key : keys)
			if(votes.get(key).equals(max))
				thePresident.add(key);
		
		//alphabeticl ordering the winners list
		Collections.sort(thePresident);
		
		for(int i =0; i< thePresident.size(); i++){
			System.out.println(thePresident.get(i));
		}
		
	}

}
