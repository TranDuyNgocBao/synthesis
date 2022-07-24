#include <iostream>

using namespace std;

int main()
{
    int a,b,c;
    int huyen,ca,cb;
    cin>>a>>b>>c;
    huyen=c;
    ca=a; cb=b;
    if(huyen<a){huyen=a;ca=c;} if(huyen<b){huyen=b;cb=c;}
    if(huyen*huyen==ca*ca+cb*cb)cout<<"YES"<<'\n'<<huyen;
     else cout<<"No";

    return 0;
}
