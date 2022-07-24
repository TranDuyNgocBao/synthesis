#include <iostream>

using namespace std;

int main()
{
    char a[301];
    cin.getline(a,300);
    int i,j,m;
    i=j=0;
    while(a[i++]==' ');i--;
    while(a[i]!='\0')a[j++]=a[i++];
    while(a[--j]==' ');a[j+1]='\0';
    for(m=0;a[m]!='\0';m++)
    {
        if((a[m]==' ')&&(a[m+1]==' ')){int n,b;
                                       n=b=m;
                                       while(a[n++]==' ');n=n-2;
                                       while(a[n]!='\0')a[b++]=a[n++];a[b]='\0';
                                       while(a[--b]!=' ');a[b]=' ';
                                      }
        else continue;
    }
    cout<<a;
    return 0;
}
