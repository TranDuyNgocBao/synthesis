#include <iostream>

using namespace std;

int main()
{
    int n,t=0;
    cin>>n;
    for(int i=1;i<=n;i++)
    {
        if(i%2!=0)t=1;else t=0;
        for(int j=1;j<=n;j++)
        {
            if(t==1)
            {
                if(j%2!=0)cout<<"W";else cout<<"B";
            }
            else
            {
                if(j%2!=0)cout<<"B";else cout<<"W";
            }
        }cout<<endl;

    }
    return 0;
}
