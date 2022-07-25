#include <stdio.h>
int max (int, int); //declare 
void swap(int* first_number, int* second_number); // call by  reference
int sum(int);
unsigned nth_fib(unsigned int nth_number);
// 1, 1, 2, 3, 5, 8, 13, 21, ....

int main()
{
    int a,b;
    printf ("Nhap a= ");
    scanf("%d", &a);
    printf("So fibonacci thu %d la %d \n",\
        a,nth_fib(a));
    return 0; 
}
//implementation

int max (int a, int b){
    return a>b ? a:b;//macro
    // if (a>b) return a;
    // else return b;
}

void swap(int* a, int* b){
    *a=*a+*b;
    *b=*a-*b;
    *a=*a-*b;
}
int sum(int n)
{
    int s=0;
    for (int i=0;i<=n;i++) s+=i;
    return s;
    // if (n<=0) return 0;
    // return n+sum(n-1);
}

unsigned nth_fib(unsigned int n){
    int fi=1, f=1;
    for (int i=3; i<=n;i++){
        fi=fi+f;//2 3 5
        f=fi-f;//1 2 3
    }
    return fi;
}

