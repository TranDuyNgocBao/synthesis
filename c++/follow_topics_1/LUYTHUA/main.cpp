#include <bits/stdc++.h>

using namespace std;
string n;
long int k,t=1;

int multimod(string &a)
{
    long int tmp=0;
    for(long int i=0;i<a.length();i++)
    {
        tmp=(int(a[i]-48+tmp*10))%10000;
    }
    return tmp;
}

int backtrack(long int i=1)
{
    t=(t%10000)*multimod(n);
    t=t%10000;
    if(i<k)backtrack(i+1);
    return t;
}

int main()
{
    long int t;
    cin>>n;
    cin>>k;
    t=backtrack();
    cout<<t;
    return 0;
}
