#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void sum(int a[], int size){

    int sum=0;
    for(int i=0;i<size;i++){
        sum=sum+a[i];
    }
    printf("-----Value Passed From Java(Printed In C)-----\n");
    printf("Sum : %d\n",sum);

}

int main(){

    return 0;

}
