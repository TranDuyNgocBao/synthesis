#include <bits/stdc++.h>

using namespace std;
int n,k,t;
long int a[1000][1000];
string tch,hang[32000],bang[32000],Max,bigtch,Sum;

int cmp(string &b,string &c)
{
    while(b.length()<c.length())b="0"+b;
    while(c.length()<b.length())c="0"+c;
    if(b==c)return 1;
    if(b<c)return 0;
    if(b>c)return -1;
}

void bigSum(string &b, string &c)
{
    while(b.length()<c.length())b="0"+b;
    while(c.length()<b.length())c="0"+c;
    long long int x,y,carry=0,s,i;
    string tmp="";
    for(i=b.length()-1;i>=0;i--)
    {
        x=int(b[i])-48; y=int(c[i])-48;
        s=x+y+carry;
        carry=s/10;
        tmp=char(s%10+48)+tmp;
    }
    if(carry>0)tmp="1"+tmp;
    Sum=tmp;
}

void Multifile1(string &bd, long long int b)
{
    long long int i,carry=0,s;
    string tmp="";
    for(i=bd.length()-1;i>=0;i--)
    {
        s=(int(bd[i])-48)*b+carry;
        carry=s/10;
        tmp=char(s%10+48)+tmp;
    }
    if(carry>0)
    {
        while(carry!=0)
        {
            tmp=char(carry%10+48)+tmp;
            carry=carry/10;
        }
    }
    tch=tmp;
}

void Multifile2(string &b, string &c)
{
    string tmp="";
    long long int m,i,j;
    m=-1;
    bigtch="0";
    for(i=b.length()-1;i>=0;i--)
    {
        m=m+1;
        Multifile1(c,int(b[i]-48));
        tmp=tch;
        for(j=1;j<=m;j++)tmp=tmp+"0";
        bigSum(bigtch,tmp);
        bigtch=Sum;
    }
}

void input()
{
    int i,j;
    cin>>n>>k;
    t=n-k+1;
    for(i=0;i<n;i++)
    {
        for(j=0;j<n;j++)
        {
            cin>>a[i][j];
        }
    }
}

void tich()
{
    int i=0,j,tmp=1,p,cop=1;
    string s="1";
    while(i<n)
    {
        for(j=0;j<n;j++)
        {
            if(j+k-1==n)break;
            for(p=j;p<=j+k-1;p++)
            {
                if(a[i][p]%2==0)
                {
                    Multifile1(s,a[i][p]);
                    s=tch;
                }
            }
            hang[tmp++]=s;
            s="1";
        }
        i++;
    }
    tmp--;
    long long int tam=tmp;
    s="1";
    Max="0";
    for(i=1;i<=tmp;i++)
    {
        p=i;
        for(j=1;j<=k;j++)
        {
            if(p>tam)hang[p]="0";
            Multifile2(s,hang[p]);
            s=bigtch;
            p=p+t;
        }
        bang[cop++]=s;
        s="1";
    }
    cop--;
    for(i=1;i<=cop;i++)
    {
        if(cmp(bang[i],Max)==-1)Max=bang[i];
    }
}

int main()
{
    //freopen("BANG1.INP","r",stdin);
    //freopen("BANG1.OUT","w",stdout);
    input();
    tich();
    if(Max=="1")cout<<"0";
    else cout<<Max;
    return 0;
}
