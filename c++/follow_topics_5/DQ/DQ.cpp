#include <bits/stdc++.h>
#define maxx 10002

using namespace std;
int n,a[maxx],b[maxx],c[maxx],s=0,m=0;

void sosanh()
{
    m=max(m,s);
}

void donhang(int k=1)
{
    s+=c[k];
    for(int i=k+1;i<=n;i++)
    {
        if(a[])
        s+=c[i];
        if(a[i]-a[k]<b[i]){s-=c[i];continue;}
        else
        {
            if(i+1==n)sosanh();
            else donhang(k+1);
            s-=c[i];
        }
    }

}

int main()
{
    freopen("DQ.INP","r",stdin);
    cin>>n;
    for(int i=1;i<=n;i++)
    {
        cin>>a[i]>>b[i]>>c[i];
    }
    sort(a+1,a+n+1);
    donhang();
    cout<<m;
    return 0;
}
