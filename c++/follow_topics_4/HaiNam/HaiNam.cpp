#include <bits/stdc++.h>

using namespace std;
long int m,n,w=0;
long int a[101*101][101*101];

void backtrack(long int i=1)
{
    long int j,t=i;
    for(j=2;j<=n;j++)
    {
        if(a[i][j]==-1)t++;
        if()
    }
}

int main()
{
    cin>>m>>n;
    for(long int i=1;i<=m;i++)
    {
        for(long int j=1;j<=n;j++)
        {
            cin>>a[i][j];
        }
    }

    return 0;
}
