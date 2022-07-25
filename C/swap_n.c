#include <stdio.h>
void swap(int *a, int *b){
    int t=*a; 
    *a=*b;
    *b=t;
}
int main (){
    int a=10; 
    int b=10;
    scanf ("%d", &b);
    printf ("a=%d, b=%d \n",a, b);
    swap(&a, &b);
    printf("Ket qua swap a, b la: %d, %d \n",a,b);
}