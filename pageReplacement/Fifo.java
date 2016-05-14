package pageReplacement;
import java.util.Scanner;

public class Fifo {
	static Scanner in = new Scanner(System.in);	
	public static void main(String[] args) {




System.out.println("Enter the size of cache momery : ");
int c = in.nextInt();
int cache[] = new int[c];
int m =0;

System.out.println("Enter demand size : ");
int d = in.nextInt();
int demand[] = new int[d];

for(int i = 0; i<d ;i++)
{
	System.out.println("enter demand : ");
	demand[i] = in.nextInt();
	
	for(int p=0;p<c;p++)
	{
		if(cache[p]==demand[i])
		{
			System.out.println("hit");
			break;
		}
		
		if(cache[p] == 0)
		{
			System.out.println("miss");
			cache[p] = demand[i];
			break;
		}
		
		if((p==(c-1))&&(cache[p]!=demand[i]))
		{
			
				cache[m]=demand[i];
				System.out.println("miss");
				m++;
				if(m==c)
				{m=0;}
				
			break;
		}
		
	}
	
	
	
	
	
	
	
	
}


	


	
	}

}
