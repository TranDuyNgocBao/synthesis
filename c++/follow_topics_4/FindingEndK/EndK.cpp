#include <bits/stdc++.h>

using namespace std;

void bigSum(string &a, string &b)
{
    long int i,sum,x,y,carry=0;
    string tmp="";
    while(a.length()<b.length())a="0"+a;
    while(a.length()>b.length())b="0"+b;
    for(i=a.length-1;i>=0;i--)
    {
        x=int(a[i])-48; y=int(b[i])-48;
        sum=x+y+carry;
        carry=sum/10;
        tmp=char(sum%10+48)+tmp;
    }
    if(carry>0)tmp="1"+tmp;
}

void Multiply()
{
    long int m,i,j;
    string tmp="";
    m=-1; Supe="";
    for(i=a.length;i>=0;i--)
    {
        m+=1;
        bigSum(m,tmp
    }
}

int main()
{

    return 0;
}
