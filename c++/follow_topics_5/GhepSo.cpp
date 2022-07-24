#include <bits/stdc++.h>

using namespace std;
string x,y;
string minn="99999999999999", maxn="0";
string solve="";

void backtrack(long int i, long int j, string solve)
{
    if((i==x.size())&&(j==y.size()))
    {
        if(solve!="")
        {
            minn=min(minn,solve);
            maxn=max(maxn,solve);
        }
    }
    if(i<=x.size()-1)backtrack(i+1,j,solve+x[i]);
    if(j<=y.size()-1)backtrack(i,j+1,solve+y[j]);
}

int main()
{
    cin>>x>>y;
    backtrack(0,0,solve);
    cout<<minn<<endl<<maxn;
    return 0;
}
