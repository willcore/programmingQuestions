import java.util.Scanner;

/*
10.0.0.1 11.199.88.254 1000.43.59.96
10.0.0.1 11.199.88.254 1000.43.59.96
10.0.0.1 11.199.88.254 10.43.59.96
10.0.0.1 11.199.88.254 111.19.12.154
 */
public class IP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		System.out.println();
		
		while(in.hasNext()){
			
			String start = in.next();
			String end = in.next();
			String toVal = in.next();
			
			if(toVal.contains("..")){
				System.out.println("InValid");
			}
			else{
			String[] starter = start.split("[.]");
			String[] ender = end.split("[.]");
			
			String[] tokener = toVal.split("[.]");
			
			String ans = eval(tokener, starter, ender);
			
			System.out.println(ans);
			}
		}
		
	}
	
	public static String eval (String[] tokener, String[] starter, String[] ender){
		
		for(int i = 0; i < tokener.length; i++ ){
		
			if((Integer.parseInt(tokener[i]) > 255 || Integer.parseInt(tokener[i]) < 0)){
				return "InValid";
			}
		}
		
		for(int i = 0; i<tokener.length-1; i++){
			
			if(!(Integer.parseInt(tokener[i]) >= Integer.parseInt(starter[i]))
					|| !(Integer.parseInt(tokener[i]) <= Integer.parseInt(ender[i]))){
				return "OutRange";
			}	
		}
		
		return "InRange";

	}

}
