#include <bits/stdc++.h>
#include <string>

using namespace std;

int main()
{
    string x,y;
    getline(cin,x);
    long int i,j,r=0;
    for(i=0;i<x.length();i++)
    {
        if(int(x[i])==32)
        {
            y=x.substr(i+1,x.length()-1);
            x=x.erase(i+1,x.length()-1);
        }
    }
    if(x.length()>=y.length())j=y.length();
    else
    {
        j=x.length();
    }
    for(i=0;i<j;i++)
    {

    }

    return 0;
}
