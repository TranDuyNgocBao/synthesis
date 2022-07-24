#include <bits/stdc++.h>

using namespace std;

int GPTBN(int t, int y, float *p)
{
    if(t==0){return 1;}
    else{*p=((-1)*float(y))/float(t);cout<<fixed;return 2;}
}
int main()
{
    float x;
    int a,b;
    cin>>a>>b;
    switch (GPTBN(a,b,&x))
    {
        case 1: cout<<"Phuong trinh vo nghiem.";break;
        case 2: cout<<"Phuong trinh co nghiem x = "<<x;cout<<endl;
    }
    return 0;
}
