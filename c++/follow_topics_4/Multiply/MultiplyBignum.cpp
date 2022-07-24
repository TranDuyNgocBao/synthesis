#include <bits/stdc++.h>

using namespace std;
string c,d,sum,t,y;

void bigSum(string &a, string &b)
{
    long int i,s,x,y,carry=0;
    string tmp="";
    while(a.length()<b.length())a="0"+a;
    while(a.length()>b.length())b="0"+b;
    for(i=a.length()-1;i>=0;i--)
    {
        x=int(a[i])-48; y=int(b[i])-48;
        s=x+y+carry;
        carry=s/10;
        tmp=char(s%10+48)+tmp;
    }
    if(carry>0)tmp="1"+tmp;
    d=tmp;
}

void multiply1(string &a, int b)
{
    long int i,s,carry;
    string tmp="";
    c="";
    carry=0;
    for(i=a.length()-1;i>=0;i--)
    {
        s=(int(a[i])-48)*b+carry;
        carry=s/10;
        c=char(s%10+48)+c;
    }
    if(carry>0)tmp=char(carry+48)+tmp;
    else tmp="";
    c=tmp+c;
}

void multiply2()
{
    long int m,i,j;
    string tmp="";
    m=-1; sum="0";
    for(i=t.length()-1;i>=0;i--)
    {
        m+=1;
        multiply1(y,int(t[i])-48);
        tmp=c;
        for(j=1;j<=m;j++)tmp=tmp+"0";
        bigSum(tmp,sum);
        sum=d;
    }
}

int main()
{
    getline(cin,t); getline(cin,y);
    if(t.length()<y.length())swap(t,y);
    multiply2();
    cout<<endl<<sum;
    return 0;
}
