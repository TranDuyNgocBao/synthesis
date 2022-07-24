#include <bits/stdc++.h>

using namespace std;

int main()
{
    freopen("BAI3L1018.INP","r",stdin);
    freopen("BAI3L1018.OUT","w",stdout);
    string a,b;
    getline(cin,a);
    a=a+" ";
    int u=0,dem=0,n,c;
    for(int i=0;i<a.length();i++)
    {
        c=0;
        int d;
        if(int(a[i])==32)
        {
            n=i-u;
            n=n/2;
            d=i-1;
            for(int j=u; j<=u+n; j++)
            {
                if(a[j]==a[d])d--;
                else {c=1;break;}
            }
            if(c==0)dem++;
            u=i+1;
        }
    }
    cout<<dem;
    return 0;
}
