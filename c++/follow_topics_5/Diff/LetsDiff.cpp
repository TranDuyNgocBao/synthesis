#include <bits/stdc++.h>
#define MAx 10000

using namespace std;
long int a[MAx],n,maxDiff,tmp1,tmp2;

void find2(long int l, long int r, long int maxDiff, long int maxValue, long int minValue)
{
    long int mid;
    long int maxD1, maxV1, minV1;
    long int maxD2, maxV2, minV2;
    if(l==r)
    {
        maxDiff=0;
        maxValue=a[r];
        minValue=a[r];
    }
    else
    {
        mid=(l+r)/2;
        find2(l,mid,maxD1,maxV1,minV1);
        find2(mid+1,r,maxD2,maxV2,minV2);
        maxDiff=maxV2-minV1;
        if(maxDiff<maxD1)maxDiff=maxD1;
        if(maxDiff<maxD2)maxDiff=maxD2;
        if(maxV1>maxV2)
        {
            maxValue=maxV1;
        }else maxValue=maxV2;
        if(minV1<minV2)
        {
            minValue=minV1;
        }else minValue=minV2;
    }
}

int main()
{
    cin>>n;
    for(long int i=1;i<=n;i++)
    {
        cin>>a[i];
    }
    find2(1,n,maxDiff,tmp1,tmp2);
    cout<<maxDiff;
    return 0;
}
