#include <bits/stdc++.h>

using namespace std;
vector<long int>x(20);
long int n,dem=0;

void output()
{
    long int i;
    for(i=1;i<=n;i++)cout<<x[i]<<" ";
    cout<<endl;
}

void XepHau(long int k=1)
{
    long int sk[1000],nsk,i,xk;
    bool ok;
    nsk=0;
    for(xk=1;xk<=n;xk++)
    {
        ok=true;
        for(i=1;i<=k-1;i++)
        {
            if((xk==x[i])||(k+xk==i+x[i])||(k-xk==i-x[i]))
            {
                ok=false;
                break;
            }
        }
        if(ok)
        {
            nsk++;
            sk[nsk]=xk;
        }
    }
    for(i=1;i<=nsk;i++)
    {
        x[k]=sk[i];
        if(k==n)output();
        else XepHau(k+1);
        x[k]=0;
    }
}

void XepHau2(long int k=1)
{
    long int sk[1000],nsk,i,xk;
    bool ok;
    nsk=0;
    for(xk=1;xk<=n;xk++)
    {
        ok=true;
        for(i=1;i<=k-1;i++)
        {
            if((xk==x[i])||(k+xk==i+x[i])||(k-xk==i-x[i]))
            {
                ok=false;
                break;
            }
        }
        if(ok)
        {
            nsk++;
            sk[nsk]=xk;
        }
    }
    for(i=1;i<=nsk;i++)
    {
        x[k]=sk[i];
        if(k==n)dem++;
        else XepHau2(k+1);
        x[k]=0;
    }
}

int main()
{
    freopen("XEPHAU.INP","r",stdin);
    freopen("XEPHAU.OUT","w",stdout);
    clock_t start = clock();
    cin>>n;
    XepHau2();
    cout<<dem<<endl;
    XepHau();
    clock_t finish = clock();
    double duration = (double)(finish - start) / CLOCKS_PER_SEC;
	cout <<"\n\n\n";
	printf("Thoi gian thuc thi: %.6lf",duration);cout<<endl;
	system("pause");
    return 0;
}
