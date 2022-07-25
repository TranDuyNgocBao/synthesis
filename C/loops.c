#include<stdio.h>
int main()
{
    int x=0;
    for (int i=1;i<=9;i++) x=x+1;
    printf("Ket qua thu 1 cua x la: %d \n",x);
    x=0;
    for (int i=9;i>0;i--) x=x+1;
    printf("Ket qua thu 2 cua x la: %d \n",x);
    x=0;
    for (int i=0;i++<=9;) x=x+1;
    printf("Ket qua thu 3 cua x la: %d \n",x);

    x=0;
    for (int i=0;i<=9;i+=2) x=x+1;
    //for (int i=0;++i<=9;) x=x+1;
    printf("Ket qua thu 3 cua x la: %d \n",x);
    int i=0;
    while(i<=9)
    {
        printf("Lan lap thu %d \n",i++);
    }
    int n;
    printf("Nhap so nguyen bat ky ");
    scanf("%ld",&n);
    
    int sum=0;
    int tmp=n;
    while(n!=0){
        sum=sum+n%10;
        n=n/10;
    }
    
    if (tmp>=0) printf("Tong cac chu so cua %d la %d",tmp,sum);
    else printf("Tong cac chu so cua %d la %d",tmp,-sum);
}