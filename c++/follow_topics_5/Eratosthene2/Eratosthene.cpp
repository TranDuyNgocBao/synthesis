#include <bits/stdc++.h>
#define Max 10000000
using namespace std;
long int r,l,Prime[Max];


void Eratosthene()
{
    long int i,j;
    memset(Prime,0,l-r+1);
    Prime[1]=1;Prime[0]=1;
    for(i=2;i<=int(sqrt(l));i++)
    {
        if(Prime[i]==0)
        {
            j=i*i;
            while(j<=l)
            {
                Prime[j]=1;
                j+=i;
            }
        }
    }
}

int main()
{
    cin>>r>>l;
    Eratosthene();
    for(long int i=r;i<=l;i++)
    {
        if(Prime[i]==0)cout<<i<<" ";
    }
    return 0;
}
