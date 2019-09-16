package test;

public class solution {
	static int [] coin = {1,4,6}; 
	static int min; 
	public static void main(String[] args) 
	{
		int money = 3; 
		min = Integer.MAX_VALUE; 
		makeChange(money, 0);
	}
	static void makeChange( int money, int cnt)
	{
		for(int i=0; i< coin.length; i++)
		{
			if(money == coin[i])
			{
				if( min > cnt +1)
				{
					min = cnt +1;
				}
				return ;
			}
			else if( money> coin[i])
			{
				makeChange(money-coin[i] , cnt+1);
			}
		}
	}
}
