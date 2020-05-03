#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void sum(int *value, int size){

    printf("-----Value Passed From Java(Printed In C)-----\n");
    int i=0;
    int sum=0;
    for(int i=0;i<size;i++){
        printf("i=%d value[%d]=%d\n",i,i,value[i]);
        sum=sum+value[i];
    }
    printf("Sum : %d\n",sum);

}

int main(){

    return 0;

}
