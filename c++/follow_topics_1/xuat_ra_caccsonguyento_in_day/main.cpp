#include <iostream>
#include <math.h>
using namespace std;

int main()
{
    int a[1001],n,i,j;
    cin>>n;
    for(i=0;i<n;i++){cin>>a[i];}
    for(i=0;i<n;i++)
    {
      for(j=2;j<=sqrt(a[i]);j++){if(a[i]%j==0)break;}
      if((j>sqrt(a[i]))&&(sqrt(a[i]>1)))cout<<a[i]<<" ";
    }
    return 0;
}
