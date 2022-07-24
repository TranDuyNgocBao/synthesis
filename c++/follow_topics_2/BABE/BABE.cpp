#include <bits/stdc++.h>

using namespace std;
long int a,b;

void input()
{
    cin>>a>>b;
}

int tong(long int n)
{
    long int i,s=0;
    for(i=1;i<n;i++)
    {
        if(n%i==0)s+=i;
    }
    return s;
}

int main()
{
    input();
    if((a==tong(b))&&(b==tong(a)))cout<<"YES";
    else cout<<"NO";
    return 0;
}
