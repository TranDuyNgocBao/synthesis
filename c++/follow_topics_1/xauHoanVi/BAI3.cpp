#include <bits/stdc++.h>
#define FOR(i,l,r)for(int i=l; i<=r; i++)

using namespace std;

int main()
{
    freopen("BAI3.INP","r",stdin);
    freopen("BAI3.OUT","w",stdout);
    ios::sync_with_stdio(0);cin.tie(0);
    int t=0;
    string a,b;
    getline(cin,a);
    getline(cin,b);
    FOR(i,0,a.length())
    {
        if(int(a[i])==32)
        {
            a.erase(i,1);
        }
    }

    FOR(i,0,b.length())
    {
        if(int(b[i])==32)
        {
            b.erase(i,1);
        }
    }
    FOR(i,0,a.length())
    {
        if(int(a[i])>=97)a[i]=char(int(a[i])-32);
    }
    FOR(i,0,b.length())
    {
        if(int(b[i])>=97)b[i]=char(int(b[i])-32);
    }
    FOR(i,0,a.length())
    {
        FOR(j,0,b.length())
        {
            t=0;
            if(a[i]==b[j]){t=1;break;}
        }
        if(t==0){cout<<"NO"; return 0;}
    }

    FOR(i,0,b.length())
    {
        FOR(j,0,a.length())
        {
            t=0;
            if(b[i]==a[j]){t=1;break;}
        }
        if(t==0){cout<<"NO"; return 0;}
    }
    cout<<"YES";
    return 0;
}
