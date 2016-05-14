package Scheduling;

import java.util.Scanner;

public class SJF_NonPreemptive {
	public static void main(String args[])
	{
		X obj = new X();
		obj.fun();
	}

}


class Matter
{
	char process_name;
	int burst_time,waiting_time,turnaround_time,response_time;
}

class X
{
	static float avgWait_time=0.0f;
	static float throughput = 0.0f;
	
	Scanner in = new Scanner(System.in);
	
	void fun()
	{
		
		System.out.println("enter the total number of processes : ");
		int n  = in.nextInt();
		Matter ob[] = new Matter[n];
		for(int i=0;i<n;i++)
		{
			ob[i] = new Matter();
			
			System.out.println("Enter the name of the process : ");
			ob[i].process_name = in.next().charAt(0);
			
			System.out.println("Enter the burst time : ");
			ob[i].burst_time = in.nextInt();
		}
	
		for(int a=1;a<n;a++)
		{
			int k = a;
			Matter temp = new Matter();
			while(k>0)
			{
				if( (ob[k-1].burst_time)>(ob[k].burst_time) )
				{
					temp = ob[k];
					ob[k] = ob[k-1];
					ob[k-1] = temp;
				}
				k--;
			}
		}
		
		
		
		for(int i =0;i<n;i++)
		{
			if(i==0)
			{
			ob[i].waiting_time = 0;
			ob[i].turnaround_time = ob[i].burst_time;
			ob[i].response_time = 0;
			avgWait_time = avgWait_time + ob[i].waiting_time;
			throughput = throughput + ob[i].burst_time;
			}
			else
			{	
			ob[i].waiting_time = ob[i-1].waiting_time + ob[i-1].burst_time;
			ob[i].turnaround_time = ob[i].waiting_time + ob[i].burst_time;
			ob[i].response_time = ob[i].waiting_time;
			avgWait_time = avgWait_time + ob[i].waiting_time;
			throughput = throughput + ob[i].burst_time;
			}
			
			System.out.println("process name : "+ ob[i].process_name);
			System.out.println("burst time : "+ ob[i].burst_time);
			System.out.println("waiting time : "+ ob[i].waiting_time);
			System.out.println("turnaround time : "+ ob[i].turnaround_time);
			System.out.println("response time : "+ ob[i].response_time);
			System.out.println("\n");
		
		}
		
		avgWait_time = avgWait_time/n;
		throughput = n/throughput;
		
		System.out.println("average waiting time : "+ avgWait_time);
		System.out.println("throughput : " + throughput);
	}
}