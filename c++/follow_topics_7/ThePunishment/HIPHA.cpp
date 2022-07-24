#include <bits/stdc++.h>

using namespace std;

int main()
{
    int n,right=0,left=0,v;
    cin>>n;
    for(int i=1;i<=n;i++)
    {
        cin>>v;
        if(v==1)left++; else right++;
    }
    cout<<abs(left-right);
    return 0;
}
