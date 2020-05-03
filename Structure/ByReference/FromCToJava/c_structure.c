#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct SampleStruct {
	
	int val;
	
}SampleStruct;

SampleStruct* getStruct(){

	SampleStruct *sval;
   	sval=(SampleStruct*)malloc(sizeof(SampleStruct));
	sval->val = 100;
	return sval;

}

int main(){

    return 0;

}
