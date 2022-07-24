#include <bits/stdc++.h>

using namespace std;
string a[11];
vector<long int>x(20);
int k, dem=0;
long int n=1,d[1000];

void out()
{
    long int i;
    for(i=1;i<=k;i++)cout<<a[x[i]]<<" ";
    cout<<endl;
}

void backtrack2(int i)
{
    for (int j=1; j<=n;j++)
    {
        if(d[j]==0)
        {
            x[i]=j;
            d[j]=1;
            if (i==k) dem++; else backtrack2(i+1);
            d[j]=0;
        }
    }
}

void backtrack(int i)
{
    for (int j=1; j<=n;j++)
    {
        if(d[j]==0)
        {
            x[i]=j;
            d[j]=1;
            if (i==k) out(); else backtrack(i+1);
            d[j]=0;
        }
    }
}

int main()
{

    freopen("CHONTEN.INP","r",stdin);
    //freopen("CHONTEN.OUT","w",stdout);
    cin>>k;
    while(cin>>a[n])n++;
    n--;
    sort(a+1,a+n);
    memset(d,0,1000);
    backtrack2(1);
    cout<<dem<<endl<<"I LOVE YOU"<<endl;
    backtrack(1);
    return 0;
}
