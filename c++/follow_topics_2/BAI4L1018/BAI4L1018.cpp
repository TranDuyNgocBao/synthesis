#include <bits/stdc++.h>

using namespace std;

int main()
{
    freopen("BAI4L1018.INP","r",stdin);
    freopen("BAI4L1018.OUT","w",stdout);
    string a;
    cin>>a;
    sort(a.begin(),a.end());
    for(int i=0;i<a.length();i++)
    {
        cout<<a[i]<<" ";
        long int n,dem=0;
        n=int(a[i]);
        while(int(a[i])==n)
        {
            dem++;
            i++;
        }
        cout<<dem<<endl;
        i--;
    }
    return 0;
}
