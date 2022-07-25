#include <stdio.h>
 
/* khai bao bien toan cuc */
int a = 20;
/* khai bao ham */
int sum(int a, int b);
 
int main ()
{
  /* khai bao bien cuc bo trong ham main */
  int a = 15;
  int b = 25;
  int c = 0;

  printf ("Gia tri cua a trong ham main() = %d\n",  a);
  c = sum( a, b);
  printf ("Gia tri cua c trong ham main() = %d\n",  c);
  
  return 0;
}

/* ham de cong hai so nguyen */
int sum(int a, int b)
{
    printf ("Gia tri cua a trong ham sum() = %d\n",  a);
    printf ("Gia tri cua b trong ham sum() = %d\n",  b);

    return a + b;
}