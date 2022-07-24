#include <bits/stdc++.h>

using namespace std;
string n,c,d,a,e,l;

void bigDiv()
{
    long int s,i,hold;
    hold=0;s=0,c="";
    for(i=0;i<n.length();i++)
    {
        hold=hold*10+int(n[i])-48;
        s=hold/10;
        hold=hold%10;
        c+=s+48;
    }
    while((c.length()>1)&&(c[0]==48))c.erase(0,1);
}

void bigMod()
{
    long int i,hold=0;
    for(i=0;i<n.length();i++)
    {
        hold=(int(n[i])-48+hold*10)%10;
    }
    d="";
    d+=hold+48;
}

void bigSum(string &a)
{
    long int sum,carry=0,i,x,y;
    string tmp="";
    while(a.length()<e.length())a="0"+a;
    for(i=e.length()-1;i>=0;i--)
    {
        x=int(e[i])-48; y=int(a[i])-48;
        sum=x+y+carry;
        carry=sum/10;
        tmp=char(sum%10+48)+tmp;
    }
    if(carry>0)tmp="1"+tmp;
    e=tmp;
    return;
}

bool beautynumber()
{
    l=n;
    if(n.length()==1)return true;
    e="0";
    long int u=n.length();
    while(u>=1)
    {
    bigDiv();
    bigMod();
    n=c;
    bigSum(d);
    u--;
    }
    if((l.length()<e.length())||(l.length()>e.length()))return false;
    else
    {
        for(long int i=0;i<l.length();i++)
        {
            if(l[i]!=e[i])return false;
        }
    }
    return true;
}

int main()
{
    getline(cin,n);
    if(beautynumber())cout<<l;
    else cout<<e;
    return 0;
}
