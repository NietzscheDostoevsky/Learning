#include<stdio.h>

// printing celcius to fahrenheit 

main()
{
	int lower, upper, step ;
	float fahr, celsius; 
	lower = 0; // lower limit 
	upper = 300 ; // upper limit 
	step = 20 ; 
       	fahr = lower ; 

	while (fahr<= upper)
	{
		celsius = (5.0/9.0) * (fahr - 32 ) ; 
		printf("%4.0f %6.1f \n", fahr, celsius);
		fahr = fahr + step ;
	}	
}
