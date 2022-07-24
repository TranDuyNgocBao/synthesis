#include <bits/stdc++.h>

using namespace std;

int main()
{
    const long int maxmn=100;
    long int a[maxmn],b[maxmn],l[maxmn][maxmn],p[maxmn];
    long int m,n,counter;
    long int i,j;
    freopen("DayChung.INP","r",stdin);
    //freopen("DayChung.OUT","w",stdout);
    cin>>m>>n;
    for(i=1;i<=m;i++)cin>>a[i];
    for(j=1;j<=n;j++)cin>>b[j];

    //quy hoach dong
    for(i=1;i<=m;i++)l[i][0]=0;
    for(j=1;j<=n;j++)l[0][j]=0;
    for(i=1;i<=m;i++)
    {
        for(j=1;j<=n;j++)
        {
            if(a[i]==b[j])l[i][j]=l[i-1][j-1]+1;
            else l[i][j]=max(l[i][j-1],l[i-1][j]);
        }
    }
    cout<<l[m][n]<<endl;

    //TRACE
    i=m;
    j=n;
    memset(p,0,sizeof(p));
    counter=0;
    while((i>0)&&(j>0))
    {
        if(a[i]==b[j])
        {
            counter++;
            p[counter]=a[i];
            i--;
            j--;
        }
        else if(l[i][j]==l[i][j-1])j--;
        else i--;
    }
    for(i=counter;i>=1;i--)cout<<p[i]<<' ';
    return 0;
}
