#include <stdio.h>

int main(int argc, char *argv[])
{
	//int i = 0;

	// go throught each string in argv
	// skip argv[0]

	for (int i = 1; i < argc; i++)
	{
		printf("arg %d: %s\n", i, argv[i]);
	}

	// making an array of strings
	char *states[] = 
	{
	    	"Maharastra", "Delhi", "Karnataka", "Goa"
	};

	int num_states = 4 ;

	for(int i = 0; i< num_states; i++)
	{
		printf("State %d: %s \n", i, states[i]); 
	}
	
}
