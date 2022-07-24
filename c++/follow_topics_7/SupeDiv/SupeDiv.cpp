#include <bits/stdc++.h>

using namespace std;
string m,n,Bs,sub,divover;

bool cmp(string &a, string &b)//compare
{
    while(a.length()<b.length())a="0"+a;
    while(a.length()>b.length())b="0"+b;
    if(a>=b)return true;
    return false;
}

void bigSum(string &a, string &b)
{
    long int i,s,x,y,carry=0;
    string tmp="";
    while(a.length()<b.length())a="0"+a;
    while(a.length()>b.length())b="0"+b;
    for(i=a.length()-1;i>=0;i--)
    {
        x=int(a[i])-48;  y=int(b[i])-48;
        s=x+y+carry;
        carry=s/10;
        tmp=char(s%10+48)+tmp;
    }
    if(carry>0)tmp="1"+tmp;
    Bs="";
    Bs=tmp;
}

void bigSub(string &a, string &b)
{
    long int i,s,borrow=0;
    sub="";
    while(a.length()<b.length())a="0"+a;
    while(a.length()>b.length())b="0"+b;
    for(i=a.length()-1;i>=0;i--)
    {
        s=int(a[i])-48-int(b[i])+48-borrow;
        if(s<0)
        {
            s+=10;
            borrow=1;
        }
        else borrow=0;
        sub=char(s+48)+sub;
    }
    while((sub.length()>1)&&(sub[0]==48))sub.erase(0,1);
}

void supeDiv()
{
    long int i,k;
    string kb[11],hold;
    kb[0]="0";
    for(i=1;i<=10;i++)
    {
        bigSum(kb[i-1],n);
        kb[i]=Bs;
    }
    hold="";
    divover="";
    for(i=0;i<m.length();i++)
    {
        hold+=m[i];
        k=1;
        while(cmp(hold,kb[k]))
        {
            k++;
        }
        divover=divover+char(k-1+48);
        bigSub(hold,kb[k-1]);
        hold=sub;
    }
    while((divover.length()>1)&&(divover[0]==48))divover.erase(0,1);
}

int main()
{
    getline(cin,m);
    getline(cin,n);
    supeDiv();
    cout<<divover;
    return 0;
}
