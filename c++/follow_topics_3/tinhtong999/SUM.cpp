#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
    float S;
    int tich,tong,n,i;
    cin>>n;
    if(n<=0){cin>>n;}
    S=0;tong=0;tich=1;
    cout<<setiosflags(ios::showpoint)<<setprecision(4);
    cout<<fixed;
    for(i=1;i<=n;i++){tong=tong+i;
                      tich=tich*i;
                      S=S+float(tong)/tich;}
    cout<<S;
    return 0;
}
