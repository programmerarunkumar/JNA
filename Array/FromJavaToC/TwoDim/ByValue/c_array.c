#include <stdio.h>
#include <string.h>
#include <stdlib.h>

const int size=3;

int main(){

    return 0;

}

void sum(int a[][size], int row, int col){

    printf("-----Value Passed From Java(Printed In C)-----\n");
    int sum=0;
    int count=0;
    for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            printf("a[%d][%d]=%d\n",i,j,a[i][j]);
            sum=sum+a[i][j];
        }
    }
    printf("Sum : %d\n",sum);

}
