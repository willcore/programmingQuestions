import java.util.ArrayList;
import java.util.Scanner;


public class palindromeDetector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		ArrayList<String> todo = new ArrayList<String>();
		
		int n = Integer.parseInt(in.nextLine());

		for(int i = 0; i < n; i++){
			
			String sentence = in.nextLine();
			todo.add(sentence);

		}
		
		for(int i = 0; i< todo.size(); i++){
			String ans = eval(todo.get(i));
			//System.out.println(todo.get(i));
			System.out.println(ans);
		}
		
	}
	
	public static String eval(String sentence){
		
		String palCheck = "";
		int palCount = 0;
		
		String[] words = sentence.split(" ");
		for(int i = 0; i < words.length; i++){

			palCheck = (palin(words[i]));
			if(palCheck == "Palindromes Detected!"){
				palCount++;
				//System.out.println(palCount);
			}
		}
		
		if(palCount >= 2)
			return "Palindromes Detected!";
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < words.length; i++){
			sb.append(words[i]);
			palCheck = palin(sb.toString());
		}
		
		return palCheck;
	}
	
	public static String palin(String word){
		//System.out.println("Evaling: " + word);
		if(word.length() <= 2)
			return "Not enough Palin Found";
		
		for(int i = 0; i < word.length(); i++){
			
			if(!(word.charAt(i) == word.charAt(word.length()-1-i))){
				return "Not enough Palin Found";
			}	
		}
		//System.out.println(word + " a pal");
		return "Palindromes Detected!";
	}

}
