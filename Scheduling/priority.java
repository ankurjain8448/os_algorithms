package Scheduling;

import java.util.Scanner;

public class priority {
	
	public static void main(String args[])
	{
	func3 ob = new func3();
	ob.func();
	}
}

class contents{
	char process_name;
	int burst_time,priority,waiting_time,turnaround_time,response_time; }


class func3  
{
	static float avgWait_time=0.0f;
	static float throughput=0.0f;
	
	static Scanner in = new Scanner(System.in);
	void func()
	{
	
		System.out.println("Enter the total number of processes : ");
		int n=in.nextInt();
		contents[] obj = new contents[n];
		System.out.println("you can assign the highest prority = 1..!!");
		for(int i=0;i<n;i++)
		{	
			obj[i] = new contents();
			
			System.out.println("For process "+(i+1)+" : ");
			
			System.out.println("enter name of the process : ");
			obj[i].process_name = in.next().charAt(0);
			
			System.out.println("burst time : ");
			obj[i].burst_time = in.nextInt();
			
			System.out.println("priority : ");
			obj[i].priority = in.nextInt();			
		}
		int w = 0,b=0;
		for(int i=0;i<n;i++)
		{
			if(obj[i].priority==1)
			{
				obj[i].response_time=w=obj[i].waiting_time = 0;
				b= obj[i].burst_time;
				break;
			}
		}
		
		int p=1;
		while(p<n)
		{
			int i=0;
			for(i=0;i<n;i++)
			{
				if(obj[i].priority==(p+1))
				{
					obj[i].response_time=w=obj[i].waiting_time = w +b;
					b= obj[i].burst_time;
				}
			}
				
			
			p++;
		}
		
		for(int i=0;i<n;i++)
		{
			obj[i].turnaround_time = obj[i].burst_time + obj[i].waiting_time;
			avgWait_time = avgWait_time + obj[i].waiting_time;
			throughput = throughput + obj[i].burst_time;
			
			System.out.println("process name : "+ obj[i].process_name);
			System.out.println("burst time : "+ obj[i].burst_time);
			System.out.println("priority : "+ obj[i].priority);
			System.out.println("waiting time : "+ obj[i].waiting_time);
			System.out.println("turnaround time : "+ obj[i].turnaround_time);
			System.out.println("response time : "+ obj[i].response_time);
			System.out.println("\n");
		}
		avgWait_time = avgWait_time/n;
		throughput = n/throughput;
		
		System.out.println("Average waiting time : "+ avgWait_time);
		System.out.println("throughput : "+ throughput);
	
	}
}

