#include <bits/stdc++.h>

using namespace std;
long int a[1003],l[2000];

void ktnt(long int b)
{

}

int main()
{
    long int n;
    cin>>n;
    for(int i=1; i<=n; i++)cin>>a[i];
    long int jmax;
    a[0]=0; a[n+1]=32000;
    l[n+1]=0;
    for(int i=n; i>=0; i--)
    {
        jmax=n+1;
        for(int j=i+1; j<=n+1; j++)
        {
            if((a[j]>a[i])&&(l[i]>l[jmax])&&())jmax=j;
            l[i]=l[jmax]+1;
        }
    }
    return 0;
}
