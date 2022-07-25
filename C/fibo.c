#include<stdio.h>

void fibo (int n)
{
    if (n<=0) printf ("Invalid value");
    if (n==1) printf ("1, 1\n");
    if (n==2) printf ("1, 1, 2\n");
    if (n>2){
        int f0=1; 
        int f1=1;
        int f2=2;
        printf("1, 1, 2");
        while (f2<=n){
            f0=f1;
            f1=f2;
            f2=f0+f1;
            if (f2<=n) printf(", %d",f2);
        }
    }
}

int main()
{
    fibo(88);
    return 0;
}