#include <stdio.h>

#define LOWER 0 // semicolon is not required 
#define UPPER 200
#define STEP 20

main()
{
	int fahr; 

	for(fahr = LOWER; fahr <= UPPER ; fahr = fahr + STEP) 
	{
		printf("%4d %6.1f\n", fahr, (5.0/9.0)*(fahr-32));
	}
}
