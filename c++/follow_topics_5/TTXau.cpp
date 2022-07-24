#include <bits/stdc++.h>
#define maxx 100000
using namespace std;

int main()
{
    freopen("TTXau.INP","r",stdin);
    freopen("TTXau.OUT","w",stdout);
    long int n,q,i,j,s=0,t=1;
    string a[maxx],b[maxx],c[maxx],r;
    cin>>n>>q;
    for(i=0;i<n+1;i++)getline(cin,a[i]);
    for(i=1;i<=q;i++)getline(cin,b[i]);
    sort(a+1,a+n+1);
    for(i=1;i<n;i++)
    {
        for(j=i+1;j<=n;j++)
        {
            if(a[i]==a[j])
            {
                a[j][0]='0';
            }
        }
        if(int(a[i][0])!=48)c[++s]=a[i];
        if((int(a[n][0])!=48)&&(i==n-1))c[++s]=a[i+1];
    }
    for(i=1;i<=q;i++)
    {
        t=1;
        if(b[i][0]=='1')
        {
            b[i]=b[i].substr(2,b[i].length());
            for(j=1;j<=s;j++)
            {
                if(c[j]==b[i])
                {
                    cout<<j<<endl;
                    t=0;
                    break;
                }
            }
            if(t==1)cout<<-1<<endl;
        }
        else if(b[i][0]=='2')
        {
            b[i]=b[i].substr(2,b[i].length());
            r=b[i];
            t=int(r[0])-48;
            if(t<=s)cout<<c[t]<<endl;
            else cout<<-1<<endl;
        }
    }

    return 0;
}
