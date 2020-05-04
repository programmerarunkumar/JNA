#include <stdio.h>
#include <stdlib.h>

int main(){

    return 0;

}

double* getDouble()
{

	double *pVal = (double*)malloc(sizeof(double));
	*pVal = 4.7;
	return pVal;

}
