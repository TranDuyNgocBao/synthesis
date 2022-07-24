#include <iostream>
#include <stdio.h>
#include <math.h>

using namespace std;

int main()
{
    short a,b,c,d,tong,S;
    short u,i;
    cout << "Nhap cac so a,b,c,d="; cin >>a>>b>>c>>d;
    S=tong=a+b+c+d;
   if (tong==10){cout<<"Tong la =" <<tong<<endl;
                cout<<"Chu so hang chuc la =" <<1<<'\n';
                cout<<"Chu so hang don vi la =" <<0<<'\n';return 0;}
   else if(tong<10&&tong>=0){cout<<"Tong la" <<S<<endl;
               cout<<"Chu so hang chuc la =" <<0<<endl;
               cout<<"Chu so hang don vi la =" <<S;return 0; }
   else{do{u=tong%100;
           tong=u;}
        while(u>=0);
        u=int(u/10);
        i=tong-u*10;

cout<<"Tong la =" <<S<<'\n';
cout<<"Chu so hang chuc la =" <<u<<'\n';
cout<<"Chu so hang don vi la =" <<i;}

 return 0;
}
