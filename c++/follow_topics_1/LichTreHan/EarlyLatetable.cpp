#include <bits/stdc++.h>
#define h 10000

using namespace std;
long int p[h],d[h],jobs[h],save[h];
long int n;

void input()
{
    cin>>n;
    long int i;
    for(i=1;i<=n;i++)
    {
        cin>>p[i];
        jobs[p[i]]=i;
    }
    for(i=1;i<=n;i++)cin>>d[i];
}

void Greedy()
{
    long int i,j;
    sort(p+1,p+n+1);
    memset(save,0,h);
    m=0;

}

int main()
{
    input();
    Greedy();
    return 0;
}
