#include <bits/stdc++.h>
#define Max 1000000
using namespace std;
string n,Sum,Sub,number[Max];
unsigned long long int phuc=0,nga;

int cmp(string &a, string &b)
{
    while(a.length()<b.length())a="0"+a;
    while(a.length()>b.length())b="0"+b;
    if(a<b)return 1;
    if(a==b)return 0;
    if(a>b)return -1;
}

void bigSum(string &a, string &b)
{
    long long int i,x,y,s,carry=0;
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
    Sum=tmp;
}

void bigSub(string &a, string &b)
{
    long long int i,borrow=0,s;
    string tmp="";
    while(a.length()<b.length())a="0"+a;
    while(a.length()>b.length())b="0"+b;
    for(i=a.length()-1;i>=0;i--)
    {
        s=int(a[i])-int(b[i])-borrow;
        if(s<0)
        {
            s+=10;
            borrow=1;
        }
        else borrow=0;
        tmp=char(s+48)+tmp;
    }
    while((tmp.length()>1)&&(tmp[0]==48))tmp.erase(0,1);
    Sub=tmp;
}

void Fibonacci()
{
    lab:
    string fi="",fi_1,fi_2,fi_3;
    if(n<="1"){++phuc;number[phuc]=n;return;}
    fi_1="0"; fi_2="1";
    while(cmp(fi,n)==1)
    {
        bigSum(fi_1,fi_2);
        fi=Sum;
        fi_3=fi_2;
        fi_1=fi_2;
        fi_2=fi;
    }
    if(cmp(fi,n)==0){++phuc;number[phuc]=n;return;}
    if(cmp(fi,n)==-1)
    {
        bigSub(fi,fi_3);
        fi=Sub;
    }
    if(fi_3[0]==48)fi_3.erase(0,1);
    ++phuc;
    number[phuc]=fi_3;
    bigSub(n,fi_3);
    n=Sub;
    if(n!="0")goto lab;
}

int main()
{
    getline(cin,n);
    Fibonacci();
    for(nga=phuc;nga>0;nga--)
    {
        cout<<number[nga];
        if(nga>1)cout<<" + ";
    }
    return 0;
}
