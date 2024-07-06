package SaurabhCollection;

import java.util.ArrayList;

public class Shrikant {

	public static void main(String[] args) {

		
		String str = "00110011";
		
		for(int i =0;i<str.length();i++)
		{
			if((str.charAt(i)=='1')&&(str.charAt(i+1)=='0')&& (str.lastIndexOf('0')>(str.charAt(i+1))&&(str.lastIndexOf('0'))!=str.indexOf('0')))
			{
				str = (str.substring(0, i)+str.substring(i,str.length()));
			}
			else if(i!=0) {
				str = (str.substring(0, i-1)+str.substring(i,str.length()));
			}
		}
		System.out.println(str);
	
	}

}

