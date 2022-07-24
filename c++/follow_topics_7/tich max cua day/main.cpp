#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    int a[10001],n,i;
    cin>>n;
    for(i=0;i<n;i++){cin>>a[i];}
    sort(a,a+n);


    return 0;
}
