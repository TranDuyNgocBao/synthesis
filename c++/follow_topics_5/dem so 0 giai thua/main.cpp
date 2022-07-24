#include <bits/stdc++.h>

using namespace std;

int main()
{
    long long int n,i,s=1,dem=0;
    cin>>n;
    for(i=1;i<=n;i++)
    {
        s=((s%10)*(i%10))%10;
        if(s==1)dem++;
    }
    cout<<2*dem;
    return 0;
}
