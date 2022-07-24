// e^x=1+(x/1!)+(x*x/2!)+...+(x^n/n!)

// x=5

#include <iostream>

using namespace std;

int main()
{
    double n,i,x;
    cin>>n>>x;
    double s=1,p=1;
    for(i=1;i<=n;++i)
    {
        p=p*x/i; // quan trong la so p = gia tri roi tiep tuc day  // => 1 dang quy hoach dong
        s=s+p;
    }
    cout<<s;
    return 0;
}
