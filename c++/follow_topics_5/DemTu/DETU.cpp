#include <bits/stdc++.h>

using namespace std;
long long i,dem,tp;

int main()
{
    string a;
    cin>>a;
    if(a[a.length()-1]!='.')a+='.';
    for(i=0;i<a.length();i++)
    {
        if(a[i]!='.')tp++;
        else
        {
            if(tp!=0)dem++;
            tp=0;
        }
    }
    cout<<dem;
    return 0;
}
