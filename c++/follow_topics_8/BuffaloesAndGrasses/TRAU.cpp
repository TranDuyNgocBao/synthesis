#include <iostream>

using namespace std;

int main()
{
    int a,b;
    cin>>a>>b;
    b=3*b-a;
    for(int i=1;i<=a;i++)
    {
        for(int j=1;j<a;j++)
        {
            if(i+j==a)break;
            if(b-14*i==8*j)
            {
                cout<<i<<" "<<j<<" "<<a-i-j;
                return 0;
            }
        }
    }cout<<-1;
    return 0;
}
