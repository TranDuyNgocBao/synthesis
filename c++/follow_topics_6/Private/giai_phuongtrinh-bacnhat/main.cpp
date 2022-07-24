#include <iostream>

using namespace std;

int main()
{
 float a,b;
 float x;
    cout << "Moi ban nhap so a , b:";
    cin >> a >> b;
    if (a!=0)
 {

     cout << "Phuong trinh co nghiem duy nhat la:"<< -b/a;
 }

 else if ((a==0) & (b==0))cout << "Phuong trinh co nghiem tuy y:"; else
    cout << "Phuong trinh vo nghiem";

 return 0;
}
