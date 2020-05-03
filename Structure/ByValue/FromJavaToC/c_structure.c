#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct SampleStruct{

	int val;

}SampleStruct;

void setStruct(SampleStruct sval){

    printf("-----Value Passed From Java(Printed In C)-----\n");
    printf("Value : %d\n",sval.val);

}

int main(){

    return 0;

}
