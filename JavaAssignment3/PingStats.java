import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PingStats {
	
	public static void main(String args[]) throws Exception{
		
		System.out.println("Enter the ip address to ping");
		String ipAddr;
		Scanner scan = new Scanner(System.in);
		
		ipAddr = scan.nextLine();
		
		System.out.println("Enter the number of ping requests to send : ");
		int numberOfPings = scan.nextInt();
		
		String pingCommand = "ping " + ipAddr + " -c" + numberOfPings;
		
		Runtime run = Runtime.getRuntime();
		Process p = run.exec(pingCommand);
		String pingResult = "";
		
		BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            pingResult += inputLine;
        }
        in.close();
		
		
		Pattern pattern = Pattern.compile("([t][i][m][e][=])([0-9]*[\\.]?[0-9]*)");
		Matcher match = pattern.matcher(pingResult);
		
		String time[] = new String[numberOfPings];
		int i=0;
		while(match.find()){
			System.out.println("Ping time = " + match.group(2) + " ms");
			time[i]= match.group(2);
			i++;
		}
		Arrays.sort(time);
		
		float medianTime;
		if(numberOfPings%2==1){
			medianTime = Float.parseFloat(time[numberOfPings/2]);
		}
		else{
			medianTime = Float.parseFloat(time[numberOfPings/2]) + Float.parseFloat(time[numberOfPings/2-1]);
			medianTime = medianTime/2;
		}
		System.out.println("Median time to ping " + ipAddr + " is " + medianTime + " ms.");
	}

}
