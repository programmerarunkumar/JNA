#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(){

    return 0;

}

void sum(int *value, int row, int col){

    printf("-----Value Passed From Java(Printed In C)-----\n");
    int sum=0;
    int index=0;
    for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            index=i*col+j;
            printf("a[%d][%d]=%d\n",i,j,value[index]);
            sum=sum+value[index];
        }
    }
    printf("Sum : %d\n",sum);

}
