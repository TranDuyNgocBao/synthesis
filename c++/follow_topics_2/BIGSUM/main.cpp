#include <bits/stdc++.h>

using namespace std;

int main()
{
   // freopen("BIGSUM.INP","r",stdin);
   // freopen("BIGSUM.OUT","w",stdout);
       char a[300],b[300],c[300],d[300];
       long int n,m,t,i,j,carry=0,dem=0;
    cin.getline(a,255);  cin.getline(b,255);
    n = strlen(a)     ;       m = strlen(b);
    if(n<m)
        {
        strcpy(d,a);
        strcpy(a,b);
        strcpy(b,d);
        }
    n = strlen(a);      m = strlen(b);     j= m-1;
    for(i=n-1;i>=0;i--)
    {
        t=int(a[i])-48+int(b[j])-48+carry;
        carry=t/10;
        if((t>=10)&&(i==0)){c[dem]=(t/10)+48;c[++dem]=(t%10)+48;dem++;continue;}
        c[dem++]=(t%10)+48;
        j--;
        if(j<0){j++;b[j]=48;}
    }
    for(i=dem-1;i>=0;i--){cout<<c[i];}
    return 0;
}
