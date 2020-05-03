#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct Point{

  int x, y;

}Point;

Point ExchangeData(Point pt){

  printf("-----Value Passed From Java(Printed In C)-----\n");
  printf("x=%d y=%d\n",pt.x,pt.y);
  
  Point ppt;
  ppt.x=200;
  ppt.y=200;
  return ppt;

}

int main(){

    return 0;

}
