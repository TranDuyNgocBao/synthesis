#include <bits/stdc++.h>
#define MAX 10000000
using namespace std;
long int n,Prime[MAX];

void Eratothene()
{
    long int i,j;
    memset(Prime,0,15*n);
    for(i=2;i<=int(sqrt(n));i++)
    {
        if(Prime[i]==0)
        {
            j=i*i;
            while(j<=n)
            {
                Prime[j]=1;
                j+=i;
            }
        }
    }
}

bool Fermat(long int u)
{
    long int t=1;
    for(long int i=1;i<=u;i++)
    {
        t=(t*2)%u;
    }
    if(t!=2)return false;
    else return true;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>n;
    Eratothene();
    for(long int i=2;i<=n;i++)
    {
        if(Prime[i]==0)
        {
            if(Fermat(i)==false)cout<<i<<" ";
        }
    }
    return 0;
}
