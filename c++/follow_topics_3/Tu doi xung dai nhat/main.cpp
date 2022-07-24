#include <iostream>
#include <string.h>
using namespace std;

int main()
{
    char s[255];
    cin.getline(s,255);
    strcat(s," ");
    int i,j,a,k,t,b,maxx=0;
    for(i=0;i<strlen(s);i++)
    {
        if((i-1==-1)&&(s[i+1]==' ')&&(maxx<i+1)){maxx=i+1;t=i;}
        if((s[i-1]==' ')&&(s[i+1]==' ')&&(maxx<i+1)){maxx=i+1;t=i;}
        a=k=j=i;
        while(s[j+1]!=' '){j++;}
        b=j;
        while((j>i)&&(s[k]==s[j])){k++;j--;}
        if((s[k]==s[j])&&(maxx<b)&&(j!=b))
            {
                j=++b;
                maxx=b;
                t=a;
            }

    }
    if(maxx==0){cout<<"-1";return 0;}
    for(i=t;i<maxx;i++)cout<<s[i];
    return 0;
}
