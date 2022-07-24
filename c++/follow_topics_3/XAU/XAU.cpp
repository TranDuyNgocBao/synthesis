#include <bits/stdc++.h>

using namespace std;

int main()
{
    string a;
    long int i,b[500],t=0,c,tmp=0;
    cin>>a;
    b[0]=10;
    for(i=0;i<a.length();i++)
    {
        if((int(a[i])>=48)&&(int(a[i])<=57))
        {
            t++;
            b[t]=int(a[i])-48;
        }
    }
   for(i=1;i<=t-3;i++)
   {
       if(b[i]<b[tmp])tmp=i;
   }
   cout<<b[tmp];
   c=0;
   for(i=tmp+1;i<=t-2;i++)
   {
       if(b[i]<b[c])c=i;
   }
   cout<<b[c];
   tmp=0;
   for(i=c+1;i<=t-1;i++)
   {
       if(b[i]<b[tmp])tmp=i;
   }
   cout<<b[tmp];
   c=0;
   for(i=tmp+1;i<=t;i++)
   {
       if(b[i]<b[c])c=i;
   }
   cout<<b[c];
   return 0;
}
