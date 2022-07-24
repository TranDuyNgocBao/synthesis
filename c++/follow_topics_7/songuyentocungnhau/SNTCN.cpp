#include <iostream>

using namespace std;

int main()
{
    int a[50],n,i,b,dem;
    cin>>n;
    for(i=0;i<=n;i++){cin>>a[i];}
    a[0]=b;dem=0;
    for(i=1;i<n;i++){
        if(b>a[i]){b=b-a[i];}
        else {b=a[i]-b;}

    if(b==1){dem=dem+1;}else continue; }
    cout<<dem;

    return 0;
}
