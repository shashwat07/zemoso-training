import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VampireNumber {

	
	public static void main(String[] args) {
		
		int v,x,y;
		x=1;
		y=1;
		
		System.out.println("The first 100 vampire numbers are :");
		
		int count=1;
		
		Vector fin = new Vector();
		
		for(int j=1;j<1000;j++){
			int f=0,m=j;
			while(m>0){
				m=m/10;
				f++;
			}
			int i = j;
			int limit = (int) Math.pow(10, f);
			for(;i<limit;i++){
				x=j;
				y=i;
				
				v=x*y;
				
				
				if(x%10 == 0 && y%10==0){
					continue;
				}
				
				Vector num = new Vector();
				Vector numv = new Vector();
				
				int p=x, q=y, z=v;
				while(p>0){
					num.addElement(new Integer(p%10));
					p=p/10;
				}
				while(q>0){
					num.addElement(new Integer(q%10));
					q=q/10;
				}
				
				while(z>0){
					numv.addElement(new Integer(z%10));
					z=z/10;
				}
				
				if(num.size() != numv.size()){
					continue;
				}
				
				
				Collections.sort(num);
				Collections.sort(numv);
				
				
								
				if(num.equals(numv)){
					fin.addElement(new Integer(v));
					//System.out.println(count + ". " + v + ". Here, x is " + x + " y is " + y +".");
					count++;
				}
				
				
				
				if(count==125){
					break;
				}
				
				
			}
			if(count==125){
				break;
			}
						
		}
		Collections.sort(fin);
		Iterator z = fin.iterator();
		count=1;
		while(z.hasNext()){
			System.out.println(count + ". " + z.next());
			count++;
			if(count>100){
				break;
			}
			
		}
		
	}

}
