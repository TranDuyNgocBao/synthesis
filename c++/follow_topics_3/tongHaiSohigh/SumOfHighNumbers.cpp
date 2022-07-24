#include <bits/stdc++.h>

using namespace std;

int main()
{
    string a,b,c="";
    cin>>a>>b;
    long int i,x,y,carry=0,s;
    while(a.length()<b.length())a="0"+a;
    while(b.length()<a.length())b="0"+b;
    for(i=a.length()-1;i>=0;i--)
    {
        x=int(a[i])-48;
        y=int(b[i])-48;
        s=x+y+carry;
        carry=s/10;
        c=char(s%10+48)+c;
    }
    if(carry>0)c="1"+c;
    cout<<c;
    return 0;
}
