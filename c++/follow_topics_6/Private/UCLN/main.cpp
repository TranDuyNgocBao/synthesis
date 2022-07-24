#include <iostream>

using namespace std;

int main()
{
    int m,n,r;
    cout<<"nhap m,n:";cin>>m>>n;
    if(m<n){int t=m;m=n;n=t;}
    while (m!=n)
    {
       r=m-n;
       if(r>n){m=r;}else{m=n;n=r;}
    }
    cout<<"UCLN="<<m;
    return 0;
}
