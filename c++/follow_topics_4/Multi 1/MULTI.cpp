#include <bits/stdc++.h>

using namespace std;
char a[1000],b[1000],c[1000],d[1000];

int SMALLMULTI(int sonhan)
{
    long long int i,carry=0,s,dem=0;
    for(i=strlen(a)-1;i>=0;i--)
    {
        s=(int(a[i])-48)*sonhan+carry;
        carry=s/10;
        c[dem++]=s+48;
    }
}

int BIGSUM()
{
    long long int n,m,j,i,t,carry=0,dem=0;
    n = strlen(a)     ;       m = strlen(b);
    if(n<m){swap(a,b);
            n = strlen(a);
            m = strlen(b);}
    j= m-1;
    for(i=n-1;i>=0;i--)
    {
        t=int(a[i])-48+int(b[j])-48+carry;
        carry=t/10;
        if((t>=10)&&(i==0)){c[dem]=(t/10)+48;c[++dem]=(t%10)+48;dem++;continue;}
        c[dem++]=(t%10)+48;
        j--;
        if(j<0){j++;b[j]=48;}
    }
    return dem;
}

int main()
{
    long long int i,m,n;
    cin.getline(a,1000);
    cin.getline(b,1000);

    return 0;
}
