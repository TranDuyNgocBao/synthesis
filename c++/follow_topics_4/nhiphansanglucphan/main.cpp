#include <bits/stdc++.h>

using namespace std;
char a[1000],b[1000],c[1000];

void cpykitu(long int t)
{
    long int i;
    for(i=t;i<t+4;i++)b[i]=a[i];
}

int tothphan(long int t)
{
    long int i,kq=0;
    for(i=t;i<t+4;i++)
    {
        long int s;
        s=b[i]-48;
        kq+=s*pow(2,t+3-i);
    }
    return kq;
}

int main()
{
    cin.getline(a,1000);
    long int i,j,k,s=0;
    k=strlen(a);
    for(i=0;i<k;i++)
    {
        cpykitu(i);
        j=tothphan(i);
        if(j>=10)c[s++]=j+55;
        else c[s++]=j+48;
        i=i+3;
    }cout<<c;
    return 0;
}
