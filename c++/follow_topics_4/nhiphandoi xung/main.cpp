#include <bits/stdc++.h>

using namespace std;
int a[100000000];

int KTDX(int x[],int b)
{
    int i;
    int c=b;
    for(i=0;i<(b+c)/2;i++)
    {
        if(a[i]==a[b]){b--;continue;}
        else return 0;
    }
    return 1;
}

int main()
{
    int n,s;
    cin>>n;
    int i,j,k,dem=0;
    for(i=1;i<=n;i++)
    {
        j=0;
        int r=i;
        while(r!=0){k=r%2;
                      r=r/2;
                    a[j]=k;
                      j++;}
        if(a[j]==0){j=j-1;}
        /*int c=j;
        for(c;c>=0;c--)cout<<a[c];
        cout<<endl;*/
        s=KTDX(a,j);
        if(s==1)dem+=1;
    }
    cout<<dem;
    return 0;
}
