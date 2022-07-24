#include <iostream>
#include <math.h>
using namespace std;
int main()
{   int n,i,k;
    cout << "Nhap so nguyen N "; cin>>n;

if(n<=1)
     {cout<<"Khong co so nguyen to nao"; return 0;}
if((n>1)&&(n<4))
     {if(n==2)cout<<"Day so nguyen to den N la 2";
      if(n==3)cout<<"Day so nguyen to den N la 2 , 3";
      return 0;}
else
i=4;
lab:
for(k=2;k<=sqrt(i);k++)
if(i%k==0)break;else cin>>i;
i++;goto lab;
if(i>=n)
return 0;
}




