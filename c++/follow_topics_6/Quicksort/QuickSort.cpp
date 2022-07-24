#include <bits/stdc++.h>
#define MaX 100000000

using namespace std;
long int a[MaX],n;

void Quicksort(long int L,long int H)
{
    long int i,j,x;
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
    if(L<j)Quicksort(L,j);
    if(i<H)Quicksort(i,H);
}

int main()
{
    cin>>n;
    for(long int i=1;i<=n;i++)cin>>a[i];
    Quicksort(1,n);
    for(long int i=1;i<=n;i++)cout<<a[i]<<" ";
    return 0;
}
