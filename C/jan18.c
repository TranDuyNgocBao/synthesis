#include <stdio.h>

void swap (int a, int b){
    int t=a; a=b; b=t;
    
    // int t = *a;
    // *a= *b;
    // *b= t;
    // printf ("a= %d, b= %d \n",*a,*b);
}
int main(){
    int a=10;
    int b=15;
    printf ("a= %d, b= %d \n",a,b);//10, 15
    swap (&a,&b); // 15, 10
    printf ("a= %d, b= %d \n",a,b); // 15, 10
}
