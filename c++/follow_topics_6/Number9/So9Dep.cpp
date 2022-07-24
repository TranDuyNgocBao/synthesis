#include <bits/stdc++.h>

using namespace std;
long long n;

int main()
{
    int s=0;
    cin>>n;
    while(n!=0)
    {
        s=(s+n%10)%10;
        n/=10;
    }
    if(s==9)cout<<"YES";else cout<<"NO";
    return 0;
}
