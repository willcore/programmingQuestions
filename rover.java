import java.util.ArrayList;
import java.util.Scanner;

/*
715589.5 106.9
715670.6 98.1
715691.9 92.2
715740.6 86.3
715764.8 85.8
715779.8 95.2
715827.9 91.0
715867.7 96.7
715888.2 98.4
715906.7 98.2
715941.5 95.3
715973.3 91.4
716060.7 91.1
716079.8 100.0
716157.6 97.0
716177.8 93.8
716178.2 95.0
716180.5 88.9
716219.1 82.3
716236.9 82.1
0.0 0.0
-1.0 -1.0
 */

public class rover {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		double currOdom, fuelWeight;
		
		currOdom = in.nextDouble();
		fuelWeight = in.nextDouble();
		
		ArrayList<Long> finalOutput = new ArrayList<Long>();
		
		while(true){
			
			if(currOdom == -1.0 &&  fuelWeight == -1.0)
				break;
			
			ArrayList<tup> dataSet = new ArrayList<tup>();
			
			ArrayList<journeyData> journey = new ArrayList<journeyData>();
			
			while(true){
				
				if(currOdom == 0.0 && fuelWeight == 0.0)
					break;
				
				dataSet.add(new tup(currOdom, fuelWeight));
				
				currOdom = in.nextDouble();
				fuelWeight = in.nextDouble();
							
			}

			double distanceTraveled;
			double usedFuel;
			
			for(int i = 0; i<dataSet.size()-1; i++){
				
				//achieved getting total valid distances
				if(dataSet.get(i).fuel - dataSet.get(i+1).fuel >= 0){
					
					distanceTraveled = dataSet.get(i+1).odom - dataSet.get(i).odom;
					usedFuel = dataSet.get(i).fuel - dataSet.get(i+1).fuel; 
					
					journey.add(new journeyData(distanceTraveled,usedFuel,dataSet.get(i+1).fuel ));
				}
			}
			
			double totalAvgMileage = 0;
			double totalFuel = 0;
			
			for(int i = 0; i<journey.size(); i++){

				totalAvgMileage +=journey.get(i).deltaOdom;
				totalFuel += journey.get(i).deltaWeight;
			}
			
			double avgKmPerKg = totalAvgMileage/totalFuel;
			
			double finFuel = dataSet.get(dataSet.size()-1).fuel;
			
			double ans = avgKmPerKg*finFuel;
			finalOutput.add(Math.round(ans));
			
			currOdom = in.nextDouble();
			fuelWeight = in.nextDouble();
		}
		
		for(int i = 0; i < finalOutput.size(); i++){
			System.out.println(finalOutput.get(i));
		}
	}
	
	
	
	public static class tup {
		double odom;
		double fuel;
		
		public tup(double readOdom, double readFuel){
			this.odom = readOdom;
			this.fuel = readFuel;
		}
	}
	
	public static class journeyData{
		double deltaOdom;
		double deltaWeight;
		double lastValidFuelWeight;
		double avgMileage;
		
		public journeyData(double odomChnge, double fuelWeighChnge, double lastValid){
			this.deltaOdom = odomChnge;
			this.deltaWeight = fuelWeighChnge;
			this.lastValidFuelWeight = lastValid;
			this.avgMileage = this.deltaOdom/this.deltaWeight;
		}
	}
	

}


