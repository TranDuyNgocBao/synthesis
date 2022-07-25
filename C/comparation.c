#include <stdio.h>
int main()
{
    int a, b, c, max;
    printf("Nhap a:");
    scanf("%d",&a);
    printf("Nhap b:");
    scanf("%d",&b);
    printf("Nhap c:");
    scanf("%d",&c);
    max = a; 
    if (b>a) max=b;
    if(c>b) max =c;
    printf("so lon nhat la %d\n",max);
    a=8;
    b=12;
    printf("%d \n",a&&b );
    printf("%d \n",a&b );

}