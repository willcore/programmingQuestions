import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class smallRodent {

/* 
 RDDR
 Speedy M 0101
 Jumper F 0101
 Slowpoke M 1101
 Terror F 1100
 Shadow F 1001
 ***
 Frisky 0101
 Sleepy 1101
 ***
 
 */
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String DNA = in.next();
		
		ArrayList<animal> malePop = new ArrayList<animal>();
		ArrayList<animal> femalePop = new ArrayList<animal>();
		
		ArrayList<parents> validRents = new ArrayList<parents>();
		
		ArrayList<String> finalAns = new ArrayList<String>();
		
		//reading in parent's data
		while(true){
			
			String ourNext = in.next();
			
			if(!ourNext.equals("***")){
				
				String currName = ourNext;
				
				String currGend = in.next();
				
				String currDNA = in.next();
				
				//turning the String of DNA into a int array
				int[] intDNA = new int[currDNA.length()];
				
				for(int i = 0; i<currDNA.length(); i++){
					intDNA[i] = currDNA.charAt(i) - '0';
				}
				
	
				//creating animal to throw into ArrayList pop of animals
				animal bae = new animal(currName, currGend, intDNA);

				if(bae.gender.equals("F"))
					femalePop.add(bae);
				else
					malePop.add(bae);
			}
			else{
				while(true){
					ourNext = in.next();
					
					if(!ourNext.equals("***")){
						
						String childName = ourNext;
						
						String childDNA = in.next();
						
						int[] integerDNA = new int[childDNA.length()];
						
						//making child's DNA into int array
						for(int i = 0; i<childDNA.length(); i++){
							integerDNA[i] = childDNA.charAt(i) - '0';
						}
						
						
						//System.out.println("Commencing Parent Search");
						boolean badpair = false;

						//Finding Parents
						for(int j =0; j<femalePop.size(); j++){  
							for(int k=0; k<malePop.size(); k++){ 
								for(int m=0; m<DNA.length(); m++){
									
									if(DNA.charAt(m)=='R' && integerDNA[m]==0){
										if(femalePop.get(j).sequence[m]==1 && malePop.get(k).sequence[m]==1 ){
											badpair = true;
											//System.out.println("Testing "+femalePop.get(j).name+" & "+malePop.get(k).name);
											//System.out.println("Killed at Term: A");
										}
									}
									if(DNA.charAt(m)=='D' && integerDNA[m]==1){
										if(femalePop.get(j).sequence[m]==0  && malePop.get(k).sequence[m]==0){
											badpair = true;
											//System.out.println("Testing "+femalePop.get(j).name+" & "+malePop.get(k).name);
											//System.out.println("Killed at Term: B");
										}
									}
									if(DNA.charAt(m)=='D' && integerDNA[m]==0){
										if(femalePop.get(j).sequence[m]==0  && malePop.get(k).sequence[m]==1 ){
											badpair = true;
											//System.out.println("Testing "+femalePop.get(j).name+" & "+malePop.get(k).name);
											//System.out.println("Killed at Term: C");
										}
										if(femalePop.get(j).sequence[m]==1  && malePop.get(k).sequence[m]==1 ){
											badpair = true;
											//System.out.println("Testing "+femalePop.get(j).name+" & "+malePop.get(k).name);
											//System.out.println("Killed at Term: D");
										}
										if(femalePop.get(j).sequence[m]==1  && malePop.get(k).sequence[m]==0){
											badpair = true;
											//System.out.println("Testing "+femalePop.get(j).name+" & "+malePop.get(k).name);
											//System.out.println("Killed at Term: E");
										}
									}
									if(DNA.charAt(m)=='R' && integerDNA[m]==1){
										if(femalePop.get(j).sequence[m]==0 && malePop.get(k).sequence[m]==0 ){
											badpair = true;
											//System.out.println("Testing "+femalePop.get(j).name+" & "+malePop.get(k).name);
											//System.out.println("Killed at Term: F");
										}
										if(femalePop.get(j).sequence[m]==0  && malePop.get(k).sequence[m]==1 ){
											badpair = true;
											//System.out.println("Testing "+femalePop.get(j).name+" & "+malePop.get(k).name);
											//System.out.println("Killed at Term: G");
										}
										if(femalePop.get(j).sequence[m]==1  && malePop.get(k).sequence[m]==0 ){
											badpair = true;
											//System.out.println("Testing "+femalePop.get(j).name+" & "+malePop.get(k).name);
											//System.out.println("Killed at Term: H");
										}
									}
					
								}
								//a legit pair?
								if(!badpair){
									validRents.add(new parents(femalePop.get(j).name, malePop.get(k).name));
								}
								badpair = false;
							}
							
						}
						

						//validRents contains all the real parents.
						ArrayList<String> niceOutput = new ArrayList<String>();
						
						for(int i = 0; i<validRents.size(); i++){
							niceOutput.add(new String(validRents.get(i).mom+"-"+validRents.get(i).dad));
						}
						
						Collections.sort(niceOutput);
												
						StringBuilder str = new StringBuilder();
						str.append(childName + " by ");
						
						for(int y = 0; y<niceOutput.size(); y++){
							if(y>0)
								str.append(" or ");
							str.append(niceOutput.get(y));
						}
						
						finalAns.add(str.toString());
						
						validRents.clear();
						
		
					}
					else{
						break;
					}
				}
				
				for(int i=0; i<finalAns.size(); i++){
					
					System.out.println(finalAns.get(i));
					
				}
				break;
			}
		}
		

	}
	
	public static class parents{
		String mom;
		String dad;
		
		public parents(String ma, String da){
			this.mom = ma;
			this.dad = da;
		}
	}
	
	public static class animal{
		String name;
		String gender;
		int[] sequence;
		
		public animal(String n, String gend, int[] dna){
			this.name = n;
			this.gender = gend;
			this.sequence = dna;
		}
	}

}
