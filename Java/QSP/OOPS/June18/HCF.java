class HCF
{
	public static int hcf(int a,int b)
	{
		if(b==0)
		{
			return a;
		}
		else
		{
			return hcf(b,a%b);
		}
	}

	public static int lcm(int a,int b)
	{
		int hcfValue=hcf(a,b);
		return (a/hcfValue)*b;
	}
	public static void main(String[] args)
	{
		System.out.println(hcf(12,18));
		System.out.println(lcm(12,18));
	}
}