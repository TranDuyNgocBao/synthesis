#include <bits/stdc++.h>

using namespace std;
char a[1000];
long long int c[10000000];
bool Ktnt(long long int n)
{
    if((n==2)||(n==3))return true;
    if((n%2==0)||(n%3)==0)return false;
    long long int k1,k2;
    k1=(n+1)%6;
    k2=(n-1)%6;
    if((k1==0)||(k2==0))return true;
    else return false;
}

void PTtsnt(long long int k)
{
    long long int i,n,j=0,s=0,u=1;
    n=k;
    i=2;
    while(n>1){
            if(Ktnt(n))
                {
                    u++;
                    cout<<n;n=n/n;
                    a[s++]=u+48;
                }
            else if((Ktnt(i))&&(n%i==0)){cout<<i;n=n/i;j=1;a[s++]=u+48;}
            else {i++;u++;}
            if((n>1)&&(j==1))cout<<"*";
            j=0;
    }
    a[s]='\0';
}

int number_convention()
{
    long long int i,de=0,j,k=0;
    c[k-1]=0;
    for(i=0;a[i]!='\0';i++)
    {
        if(a[i]!=48){de++;c[i]=a[i]-48;}
        else break;
    }
    for(i=0;i<de;i++)
    {
        if(c[i]!=0)
        {
            if(c[i]!=c[i-1])k++;
            for(j=i+1;j<de;j++)
            {
                k++;
                if(j-i>1)k++;
            }
        }
    }
    k++;
    return k;
}

int main()
{
    long long int n,dem;
    cin>>n;
    memset(a,0,1000);
    cout<<"a) ";
    PTtsnt(n);cout<<endl;
    cout<<"b) ";
    dem=number_convention();
    cout<<dem;

}
