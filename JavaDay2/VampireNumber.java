import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class VampireNumber {

	
	public static void main(String[] args) {
		
		int vampireNumber,firstNumber,secondNumber;
		firstNumber=1;
		secondNumber=1;
		
		System.out.println("The first 100 vampire numbers are :");
		
		int count=1;
		
		Vector<Integer> vNumbers = new Vector<Integer>();
		
		for(int j=1;j<1000;j++){
			int order=0,m=j;
			while(m>0){		// to check for order of j
				m=m/10;
				order++;
			}
			int i = j;
			int limit = (int) Math.pow(10, order);
			for(;i<limit;i++){		// checks for i,j having the same number of digits.
				firstNumber=j;
				secondNumber=i;
				
				vampireNumber=firstNumber*secondNumber;
				
				
				if(firstNumber%10 == 0 && secondNumber%10==0){		// since both can't have trailing zeros
					continue;
				}
				
				Vector<Integer> bothNumbers = new Vector<Integer>();
				Vector<Integer> vampNumber = new Vector<Integer>();
				
				int fNum=firstNumber, sNum=secondNumber, vNum=vampireNumber;
				
				// Adding digits of first number in bothNumbers vector
				while(fNum>0){
					bothNumbers.addElement(new Integer(fNum%10));
					fNum=fNum/10;
				}
				
				// Adding digits of second number in bothNumbers vector
				while(sNum>0){
					bothNumbers.addElement(new Integer(sNum%10));
					sNum=sNum/10;
				}
				
				// Adding digits of vampire number in vampNumbers vector
				while(vNum>0){
					vampNumber.addElement(new Integer(vNum%10));
					vNum=vNum/10;
				}
				
				// if size of the vectors don't match -> not vampire number
				if(vampNumber.size() != vampNumber.size()){
					continue;
				}
				
				
				Collections.sort(bothNumbers);
				Collections.sort(vampNumber);
				
				
				// both vectors should have same digits if satisfying vampire number conditions. 
				if(bothNumbers.equals(vampNumber)){
					vNumbers.addElement(new Integer(vampireNumber));
					count++;
				}
				
				
				
				if(count==125){		// 125 vampire numbers taken so no number is missed in top 100.
					break;
				}
				
				
			}
			if(count==125){
				break;
			}
						
		}
		// sorted all 125 vampire numbers
		Collections.sort(vNumbers);
		Iterator<Integer> itr = vNumbers.iterator();
		count=1;
		while(itr.hasNext()){
			System.out.println(count + ". " + itr.next());
			count++;
			if(count>100){
				break;
			}
			
		}
		
	}

}
