#include <iostream>

using namespace std;

int main()
{
    int x;
    char n;
    cin>>n;
    x=int(n);
    if((x>=48)&&(x<=57)){cout<<n<<" la chu so";return 0;}
    else if((x>=59)&&(x<=90)){cout<<n<<" la ki tu chu cai in hoa";return 0;}
    else if((x>=97)&&(x<=122)){cout<<n<<" la ki tu chu cai thuong";return 0;}
    else {cout<<n<<" khong la ki tu chu cai hay so";}
    return 0;
}
