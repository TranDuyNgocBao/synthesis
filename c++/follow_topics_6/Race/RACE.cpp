#include <iostream>
#include <algorithm>
using namespace std;

int main()

{
    int n,a[1000],i,x,y,dem,b[1000],g,t,c;
    cin>>n;
    for(i=0;i<n;i++){cin>>a[i];}
    sort(a,a+n-1);
    dem=1;
    for(int j=0;j<(n-1);j++){x=a[j];y=a[j+1];
                             for(c=0;c<(n-1);c++)
                             {
                                 b[c]=dem;
                                 if(x==y){dem=dem+1;b[c]=dem;}
                             else continue;}}
    for(t=0;t<(n-1);t++){if(b[t]<b[t+1]){cout<<a[t+1]<<" "<<b[t+1];return 0;}
                                             else if(b[t]>b[t+1]){cout<<a[t]<<" "<<b[t]; return 0;}
                                             else {cout<<a[t]<<" "<<b[t];}}
}
