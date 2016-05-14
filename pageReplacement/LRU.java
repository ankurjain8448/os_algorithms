package pageReplacement;
import java.util.Scanner;

public class LRU {
	
	public static void main(String[] args) {
		
		Chal hat = new Chal();
		hat.kyu();
		
	}

}


class Chal
{
	static Scanner in = new Scanner(System.in);
	void kyu()
	{
		
		
		System.out.println("enter the demand size : ");
		int d = in.nextInt();
		int demand[] = new int[d];
		
		System.out.println("enter demand : ");
		for(int i= 0;i<d;i++)
		{
			demand[i] = in.nextInt();
		}
		
		System.out.println("enter cache size : ");
		int c = in.nextInt();
		
		int cache[] = new int[c];
		int occur[] = new int[c];
		
		int l = 0;
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
				
				if( (cache[p]!=demand[i])&&(p==(c-1)) )
				{
					for(int j=0;j<c;j++)
					{
						int find=0;
						for(int f=0;f<i;f++)
						{
							if(cache[j]==demand[f]) find++;
						}
						
						if(j==l) continue;
						else occur[j]=find;
						
					}
					
					int min = occur[0];
					for(int m=0;m<c;m++)
					{
						if(min>occur[m]) min = occur[m];
					}
					
					for(l=0;l<c;l++)
					{
						if(occur[l]==min)
						{
							cache[l]=demand[i];
							System.out.println("miss");
							break;
						}
					}
					
					for(int m=0;m<c;m++)
					{
						occur[m]=0;
					}
					
					occur[l]=100;
					break;
					
				}
				
			}
			
		}
			
	}
}