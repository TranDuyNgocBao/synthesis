#include <bits/stdc++.h>

using namespace std;

int GPTBN(int t, int y, float *p)
{
    if(t==0){return 1;}
    else{*p=((-1)*float(y))/float(t);return 2;}
}

int PTBH(int x,int y, int z, float *p,float *q)
{
    int d;
    d=y*y-4*x*z;
    if(d<0)return 0;
    else if(d==0){*p=*q=(-1*float(y)/(2*float(x)));return 1;}
    else
    {
        *p=((-float(y)+float(sqrt(d)))/(2*x));
        *q=((-float(y)-float(sqrt(d)))/(2*x));
        return 2;
    }
}

int main()
{
    float x,x1,x2;
    int a,b,c;
    cin>>a>>b>>c;
    if(a==0)
    {
       switch (GPTBN(b,c,&x))
       {
            case 1: cout<<"Phuong trinh vo nghiem.";break;
            case 2: cout<<"Phuogn trinh co nghiem x = "<<endl;
                    cout<<setiosflags(ios::showpoint)<<setprecision(2)<<x;
                    cout<<fixed;
       }
    }
    else
    {
        switch (PTBH(a,b,c,&x1,&x2))
        {
            case 0: cout<<"Phuong trinh vo nghiem.";break;
            case 1: cout<<"Phuong trinh co nghiem kep x = "<<x1;break;
            case 2: cout<<"Phuong trinh co 2 nghiem phan biet "<<endl;
                    cout<<setiosflags(ios::showpoint)<<setprecision(2)<<"x1 = "<<x1<<endl<<"x2 = "<<x2;
                    cout<<fixed;
        }
    }
    return 0;
}
