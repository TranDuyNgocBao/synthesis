#include <bits/stdc++.h>
#define MAX 200
using namespace std;
long int x[MAX],a,k,dem=0;

void Recordtest(long int x[])
{
    long int i;
    for(i=1;i<=k;i++)
    {
        cout<<x[i]<<" ";
    }cout<<endl;
}

void Combination1(long int i)
{
    long int j;
    for(j=x[i-1]+1;j<=a-k+i;j++)
    {
        x[i]=j;
        if(i==k)Recordtest(x);
        else Combination1(i+1);
    }
}

int Calculate()//Day la cach 1 tinh toan cham phu thuoc vào du lieu
{              //=> Cach 2 viet combination2 de dem ok....
    long long int i,s=1,t=1,p=1;
    for(i=1;i<=a;i++)s=s*i;
    for(i=1;i<=k;i++)t=t*i;
    for(i=1;i<=(a-k);i++)p=p*i;
    t=t*p;
    s=s/t;
    return s;
}

int main()
{
    cin>>a>>k;
    cout<<Calculate()<<endl;
    x[0]=0;
    Combination1(1);
    return 0;
}
