#include <bits/stdc++.h>

using namespace std;

int main()
{
    long n,j,i,Max,S;
    cin>>n; int a[n+4];
    for(i=0;i<n;i++)cin>>a[i];
    Max=a[0];
    for(i=0;i<n;i++)
    {   S=0;
        for(j=0;j<n;j++)
        {   S+=a[j];
            if(S>Max)Max=S;
        }
    }
    cout<<Max;
    return 0;
}
