#include <bits/stdc++.h>

using namespace std;
long long n,a[10001],i=0;

int main()
{
    cin>>n;
    do{ a[i++]=n%2;
        n/=2; }while(n>0);
    for(long int j=i-1;j>=0;j--)cout<<a[j];
    return 0;
}
