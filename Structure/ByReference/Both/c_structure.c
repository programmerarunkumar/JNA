#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Point{

  int x;
  int y;

}Point;

Point* ExchangeData(Point* pt){

  printf("-----Value Passed From Java(Printed In C)-----\n");
  printf("x=%d y=%d\n",pt->x,pt->y);
    
  Point *ppt;
  ppt=(Point*)malloc(sizeof(Point));
  ppt->x=200;
  ppt->y=200;

  return ppt;
  
}

int main(){

  return 0;

}
