#include <bits/stdc++.h>

using namespace std;
int c,n,s,a[150],x[150];

void input()
{
    cin>>n>>s;
    for(int i=1;i<=n;i++)cin>>a[i];
}

void Greedy()
{
    int i;
    memset(x,0,sizeof(x));
    sort(a,a+n+1);
    c=0;
    for(i=n;i>0;i--)
    {
        if(s>=a[i])
        {
            c++;
            x[i]=1;
            s=s-a[i];
        }
    }
}

void output()
{
    if(s==0)
    {
        cout<<c<<endl;
        for(int i=1;i<=n;i++)
        {
            if(x[i]==1)cout<<a[i]<<" ";
        }
    }
    else cout<<"No";
}

int main()
{
    input();
    Greedy();
    output();
    return 0;
}
