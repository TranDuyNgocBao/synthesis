#include <iostream>
#include <string.h>

using namespace std;

int main()
{
    long n;
    cin>>n;
    long i,j;
    char a[MAX];
    memset(a,0,a);
    for(i=2;i<=int(sqrt(n));i++)
    {
        if(a[i]==0)
        {
            j=i*i;
            while(j<n=)
            {
                a[j]=1;
                j=j+i;
            }
        }
    }
    for(i=2;i<n;i++){if(a[i]==0)cout<<i;}
    return 0;
}
