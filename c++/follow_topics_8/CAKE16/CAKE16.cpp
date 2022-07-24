#include <bits/stdc++.h>

using namespace std;
long int n, f[1003][1003];

int main()
{
    cin>>n;
    f[0][0]=f[2][0]=1;
    for(int i=2;i<=n;i++)f[i][i]=1;
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n;j++)
        {
            f[i][j]=f[i][j]+f[i-1][j-1]+f[i][j-1];
        }
    }
    cout<<f[n][n];
    return 0;
}
