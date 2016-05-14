package Scheduling;

import java.util.Scanner;

public class Round_Robin {
	public static void main(String[] args) {
	
		abc ab = new abc();
		ab.def();
	}

}


class variable{
	char process_name;
	int burst_time,waiting_time,turnaround_time,response_time;
}

class abc 
{
	static float avgWait_time=0.0f;
	static float throughput = 0.0f;
	
	Scanner in = new Scanner(System.in);
	
	void def()
	{
		System.out.println("enter the total number of processes : ");
		int n  = in.nextInt();
		variable ob[] = new variable[n];
		for(int i=0;i<n;i++)
		{
			ob[i] = new variable();
			
			System.out.println("Enter the name of the process : ");
			ob[i].process_name = in.next().charAt(0);
			
			System.out.println("Enter the burst time : ");
			ob[i].burst_time = in.nextInt();
		}
	
		
		while(true)
		{
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}