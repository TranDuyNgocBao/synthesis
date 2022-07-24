#include <iostream>
#include <string.h>
using namespace std;

int main()
{
    char a[1002];
    int i=0,maxx=0,x;
    cin.getline(a,101);
    strcat(a," ");
    for(i=0;i<strlen(a)-2;i++)
    {
        int k=0,j=i;
        while(a[j]!=' '){j++;k++;}
        if(k>maxx){maxx=k;x=i;}
    }
    while(a[x]!=' '){cout<<a[x];x++;}
    return 0;
}
