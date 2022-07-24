#include<bits/stdc++.h>

using namespace std;
long long int n;

long long int tong(long long int s)
{
	long long int i,tmp=0;
	for(i=1;i<=int(sqrt(n));i++)
	{
		if(s%i==0)
		{
			if((i!=1)&&(i*i-s!=0))tmp+=(s/i)+i;
			else tmp+=i;
		}
	}
	return tmp;
}

int main()
{
	cin>>n;
	long long int S;
	S=tong(n);
	if(S==n)cout<<"YES";
	else cout<<"NO";
}
