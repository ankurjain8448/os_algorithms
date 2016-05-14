package Scheduling;

import java.util.Scanner;

public class Fcfs {
	public static void main(String[] args) {
		
		M m = new M();
		m.mm();
	}

}


class Cont
{
	char process_name;
	int burst_time,waiting_time,turnaround_time;

}

class M
{
	static float throughput = 0.0f;
	static float avgWait_time=0.0f;
	Scanner in = new Scanner(System.in);
	void mm()
	{
		try{
		System.out.println("enter total number of processes : ");
		int n = in.nextInt();
		
		Cont obj[] = new Cont[n];
		
		for(int i =0;i<n;i++)
		{
			obj[i] = new Cont();
			
			System.out.println("Enter name of process : ");
			obj[i].process_name = in.next().charAt(0);
			
			System.out.println("Enter burst time of process : ");
			obj[i].burst_time = in.nextInt();
			
		}
		
		
		for(int i=0;i<n;i++)
		{
			if(i==0)
			obj[i].waiting_time = 0;
			else
				obj[i].waiting_time = obj[i-1].waiting_time + obj[i-1].burst_time;
			
			avgWait_time = avgWait_time +obj[i].waiting_time; 
			obj[i].turnaround_time = obj[i].waiting_time + obj[i].burst_time;
		
		}
		
		avgWait_time = avgWait_time/n;
		
		
		for(int i =0;i<n;i++)
		{
			System.out.println("process name : "+obj[i].process_name);
			System.out.println("burst time : "+obj[i].burst_time);
			System.out.println("waiting time : "+obj[i].waiting_time);
			System.out.println("turnaround time : "+obj[i].turnaround_time);
			System.out.println("\n");
			
			throughput = throughput + obj[i].burst_time;
		}
		
		throughput = n/throughput;
		
		System.out.println("average waiting time : "+avgWait_time);
		System.out.println("throughput : "+throughput);
		}
		catch(Exception e)
		{
			System.out.println("Run time exception occured..");
			System.out.println("program terminated...");
		}
	}
}