package Banker_Algo;

import java.util.Scanner;

public class Bankers_Algorithm {
	public static void main(String[] args) {
		
		Working obj = new Working();
		obj.work();
	}
}


class object{
	char p_name;
	int allocation[] ,max[];
}

class Working{
	static char last[] ;
	static int available[];
	static Scanner in = new Scanner(System.in);
	void work()
	{
		
		System.out.println("enter the number of instances : ");
		int i =in.nextInt();
		available =  new int[i];
		System.out.println("Enter the values of available instances/resources : ");
		for(int j=0;j<i;j++)
		available[j] =in.nextInt();
		System.out.println("Enter the total no of processes : ");
		int n = in.nextInt();
		last = new char[n];
		object obj[] = new object[n];
		for(int j = 0;j<n;j++)
		{
		obj[j] = new object();
		System.out.println("enter the name of the process : ");
		obj[j].p_name = in.next().charAt(0);
		obj[j].allocation = new int[i];
		obj[j].max = new int[i];
		for(int p = 0;p<i;p++)
		{
			System.out.println("enter for allocation matrix for resource "+p+" : ");
			obj[j].allocation[p] = in.nextInt();
		}
		for(int p = 0;p<i;p++)
		{
			System.out.println("enter for max matrix for resource "+p+" : ");
			obj[j].max[p] = in.nextInt();
		}
		}
		int m = 0;
		while(m!=n)
		{
			
			for(int p=0;p<n;p++)
			{
				int flag = 0;
				for(int j =0;j<i;j++)
				{
					if( (obj[p].max[j]-obj[p].allocation[j])<= available[j])
					{
						flag = flag+1;
					}
				}
				
				if(flag != i)
				{
					System.out.println("process "+obj[p].p_name+" can't b executed ");
				}
				if(flag == i)
				{
					for(int y =0 ;y<n;y++)
					{
						if(last[y]==obj[p].p_name)
							break;
						if(y==(n-1) &&(last[y]!=obj[p].p_name))
						{
							System.out.println("process "+obj[p].p_name+" completed");
							for(int j =0;j<i;j++)
							available[j]  = available[j] +obj[p].allocation[j];
							last[m] = obj[p].p_name;
							m++;
							if(m==n) System.exit(0);
						}
					}
					
				}
			
			
			}
		
		
		}
	}
}