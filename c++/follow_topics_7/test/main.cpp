#include <iostream>
#include<conio.h>
using namespace std;
int x[20];
int n;
int sd =0;
void xuatkq(int x[])
     {
     int i;
     for(i=0; i<n; i++)
     cout<< " "<< x[i];
     cout<<endl;
     }
void thu(int k)
{
     int i;
     if (k==n)
     { sd++;
     xuatkq(x);
     }
     else
      for (i=0; i<=1; i++)
      {
        x[k] = i;
        thu(k+1);
      }
 }

 int main()
 {
     int i;
     cout<<"Nhap vao mot so n= "; cin>>n;
     thu(0);
     cout<<"\n So day la: "<<sd;
     getch();
     return 0;
 }
