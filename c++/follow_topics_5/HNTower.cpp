#include <bits/stdc++.h>

using namespace std;
long int dem=0,l;
long int ct[11];

void moved(long int n, long int cot1, long int cot2, long int cot3)
{
    if(l==0)return;
    if(n==1)
    {
        //cout<<"chuyen dia tu "<<cot1<<" sang "<<cot2;
        //cout<<endl;
        //dem++;
        ct[cot1]--;
        ct[cot2]++;
        l--;
    }
    else
    {
        moved(n-1,cot1,cot3,cot2);
        moved(1,cot1,cot2,cot3);
        moved(n-1,cot3,cot2,cot1);
    }
}

int main()
{
    long int k,c1=1,c2=2,c3=3;
    cin>>k>>l;
    ct[c1]=k;
    ct[c2]=ct[c3]=0;
    moved(k,c1,c2,c3);
    //cout<<dem;
    cout<<ct[c1]<<' '<<ct[c2]<<' '<<ct[c3];
    return 0;
}
