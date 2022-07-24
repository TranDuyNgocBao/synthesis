//USING BACKTRACK
#include <bits/stdc++.h>

using namespace std;
vector <int>x(21),bestsolution(21);
const int oo=1000000;
int sum=0,best;
int a[21][21],n,c[100],cmin;
//clock_t start,finish;

void input()
{
    cmin=oo;
    cin>>n;
    int i,j;
    for(i=1;i<=n;++i)
    {
        for(j=1;j<=n;++j)
        {
            cin>>a[i][j];
        }
    }
    for(i=1;i<=n;++i)
    {
        for(j=1;j<=n;++j)
        {
            if(a[i][j]<=cmin){cmin=a[i][j];}
        }
    }

}

void update()
{
    int kt;
    kt=sum+a[x[n]][1];
    if(kt<best)
    {
        best=kt;
        for(int i=1;i<=n;++i)
        {
            bestsolution[i]=x[i];
        }
    }
}

void Backtrack(int i=2)
{
    if(cmin*(n-i+1)+sum>=best)return;//Nhánh Cận
    for(int j=1;j<=n;++j)
    {
        if(c[j])
        {
            x[i]=j;
            c[j]=0;
            sum+=a[x[i-1]][j];
            if(i==n)update();
            else Backtrack(i+1);
            sum=sum-a[x[i-1]][j];
            c[j]=1;
        }
    }
}

void prepare()
{
    memset(c,1,sizeof(c));
    x[1]=1;c[1]=0;
    best=oo;
}

void output()
{
    cout<<best<<endl;
    for(int i=1;i<=n;++i)
    {
        cout<<bestsolution[i];
        if(i<n)cout<<" to => ";
    }
}

int main()
{
    freopen("SALESMAN.INP","r",stdin);
    //freopen("SALESMAN.OUT","w",stdout);
    //start=clock();
    input();
    prepare();
    Backtrack();
    output();
    /*finish=clock();
    double duration=(double)(finish-start)/CLOCKS_PER_SEC;
    cout<<"\n\n\n";
    printf("%.4f",duration);cout<<endl;
    system("pause");*/
    return 0;
}
