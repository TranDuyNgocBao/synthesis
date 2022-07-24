#include <bits/stdc++.h>
#define FOR(i,l,r)for(int i=l; i<=r; i++)

using namespace std;

int main()
{
    //freopen("BAI3.INP","r",stdin);
    //freopen("BAI3.OUT","w",stdout);
    string a,b;
    getline(cin,a); getline(cin,b);
    FOR(i,0,a.length())
    {
        if(int(a[i]==32))a.erase(i,i);
        i=-1;
    }
    cout<<a;
    return 0;
}
