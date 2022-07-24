#include <bits/stdc++.h>

using namespace std;
char b[255],a[255],c[255];

void XOAKT(int c, int h)
{
    int i, j=c+1;
    for(i=h; a[i]!='\0'; i++)
    {
        a[i]=a[j];
        j++;
    }
}

int KTXDX(int n)
{
    int i=0,t;
    t=(i+n)/2;
    for(i;i<t;i++)
    {
        n--;
        if(b[i]!=b[n])return 0;
    }
    return 1;
}

int main()
{
    freopen("TDXDN.INP","r",stdin);
    freopen("TDXDN.OUT","w",stdout);
    cin.getline(a,255);
    int i=0,j=0,kt,s,maxx=0;
    strcat(a," ");
    lab:
        {while(a[i]==' '){XOAKT(i,j);}}
    while((a[i++]!=' ')&&(a[i-1]!='\0'))
        {
         if(a[i]==' '){kt=0;
                       s=i-j;
                       strncpy(b,a,s);
                       kt=KTXDX(s);
                       if((kt==1)&&(s>maxx)){maxx=s;strncpy(c,b,s);}
                      }
         if(a[i]==' '){XOAKT(i,j);i=0;}
         if(a[i]==' '){goto lab;}
        }
    if(maxx==0)cout<<-1;
    else cout<<c;
    return 0;
}
