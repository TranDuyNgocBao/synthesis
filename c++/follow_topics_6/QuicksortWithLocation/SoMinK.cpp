#include <bits/stdc++.h>
#define MAX 10000000

using namespace std;
long int a[MAX],k,n;

void QuickSort(long int L, long int H)
{
    long int i,j,x;
    if((L<=k)&&(k<=H))
    {
        i=L;
        j=H;
        x=a[rand()%(j-i+1)+i];
        do
        {
            while(a[i]<x)i++;
            while(a[j]>x)j--;
            if(i<=j)
            {
                swap(a[i],a[j]);
                i++;
                j--;
            }
        }while(i<j);
        if(i<H)QuickSort(i,H);
        if(j>L)QuickSort(L,j);
    }
}

int main()
{
    cin>>n>>k;
    for(long int i =1;i<=n;++i)cin>>a[i];
    QuickSort(1,n);
    cout<<a[k];
    return 0;
}
