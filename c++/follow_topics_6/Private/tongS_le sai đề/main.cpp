#include <iostream>
#include <math.h>
#include <iomanip>
using namespace std;

int main()
{
    unsigned int tu,mau,n,i;
    float S;
    cout<<setiosflags(ios::showpoint)<<setprecision(5);
    cout<<"Nhap so n=";cin>>n;
    tu=6;mau=1;S=2;
    if (n<=3){cout<<"Phai nhap so tu nhien lon hon 3.";
    return 0;}
    else for(i=3;i<=n;i++){
        tu=tu+(2*i);mau=mau*(2*i-3);
        S=S+(float(tu)/mau);
    }
    cout<<"Tong can tim la:"<<S;
    return 0;
}
