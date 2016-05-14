package pageReplacement;
import java.util.Scanner;

public class OPR {
	public static void main(String[] args) {

		avehi hur = new avehi();
		hur.chal();
	}

}



class avehi
{
	static Scanner in = new Scanner(System.in);
	void chal()
	{
		
		System.out.println("enter the demand size : ");
		int d = in.nextInt();
		
		int demand[] = new int[d];
		for(int q=0;q<d;q++)
		{
		System.out.println("Enter the demand : ");
		demand[q]= in.nextInt();
		}
		
		System.out.println("enter the size of cache : ");
		int c= in.nextInt();
		
		int cache[]= new int[c];
		int occur[] = new int[c];
		
		for(int i=0;i<d;i++)
		{
			for(int p=0;p<c;p++)
			{
				if(cache[p]==demand[i])
				{
					System.out.println("hit");
					break;
				}
				
				if(cache[p]==0)
				{
					System.out.println("miss");
					cache[p]= demand[i];
					break;
				}
				
				if( (p==(c-1))&&(cache[p]!=demand[i]) )
				{
					for(int w=0;w<c;w++)
					{
						int find=i+1;
						while(cache[w]!=demand[find])
						{
							
							if(find==(d-1)) break;
							find++;
							
						}
						
						occur[w] = find;
					}
					
					int max=occur[0];
					for(int j=1;j<c;j++)
					{
						if(occur[j]>max) max=occur[j];							
					}
					
					for(int j=0;j<c;j++)
					{
						if(occur[j]==max)
						{
							cache[j]= demand[i];
							System.out.println("miss");
							break;
						}
					}
					
					for(int w=0;w<c;w++)
					{
						occur[w]=0;
					}
				break;				
				}
			}
			
		}
		
		
	
	}
}