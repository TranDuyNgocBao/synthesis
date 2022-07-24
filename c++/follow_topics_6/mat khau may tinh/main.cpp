#include <iostream>
#include <string.h>
#include <math.h>
using namespace std;

int main()
{
    unsigned int n,i,j,b;
    int dem;
    n=pow(10,6);
    char s[n+1],t[n+1];
    cin.getline(s,n+1);
    int k=1;
    lab:
    i=strlen(s)-k;
    dem=1;
    while((i>0)&&(dem==1))
    {
        for(j=strlen(s)-2;j>0;j--)
        {
            if(s[i]==s[j]){dem=dem+1;}
            if((dem>=3)&&(s[i]==s[j])){b=j;}
        }
        if(dem>=3){strncpy(t,s,b+1);}
        if(dem<3){dem=0;i--;}
    }
    if(dem==1){cout<<"Just a joke"; return 1;}
    for(i=0;i<strlen(t)-1;i++)
    {
        dem=0;
        for(j=0;j<strlen(s);j++)
        {
            if((t[i]==s[j])&&(t[i+1]==s[j+1])){dem=dem+1;}
        }
        if(dem<3){k++;goto lab ;}
        if(dem>=3){b=i+1;}continue;
    }
    cout<<t;
    return 0;
}
