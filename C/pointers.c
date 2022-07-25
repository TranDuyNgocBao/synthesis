#include <stdio.h>
// #define PI 3.14

//     int const x = 50;

// int sample (int *p1, int *p2)
// {   int t= (*p1) + (*p2) > 12 ? 5:6;
//     return t;
// }


// void swap(int *p1, int *p2)
// {
//     int t= *p1;
//     *p1 = *p2;
//     *p2 = t;
// }

int main()
{  
//   int a_array[4]={1,2,3,4};
    int n2= 10;
    int n1= 6;
    int n0= 5;
  // swap (&n2,&n1);
  // printf("t= %d\n",sample(&n1,&n2));
  // printf("dia chi cua X=%x\n",&x);
    printf("n2=%d, n1=%d, n0=%d\n", n2, n1, n0);
    int *p = &n1; // pointer p chua dia chi cua n1 
    printf("dia chi cua n2=%x, n1=%x, n0=%x\n", &n2, &n1, &n0);
    //printf("%x va %lf va %x\n",p,*p,&p);
   *p=9; // *p --> gia tri cua n1 tro thanh 9
   printf("gia tri cua p=%x\n", p);
   p++; 
   printf("gia tri cua p=%x\n", p);
   *p=15; 
   p--;
   p--;
   printf("gia tri cua p=%x\n", p);
   *p=-3;
   printf("n2=%d, n1=%d, n0=%d\n", n2, n1, n0);
//    printf("Array sample \n");
//    for (int i=0;i<=5;i++){
//        printf("%x\t",&a_array[i]);
//    }
//     printf("\n");
//    for (int i=0;i<4;i++){
//        printf("%d\t",a_array[i]);
//    }
//     printf("%c\t",a_array[4]);
//     char c[12]="Hello World";
//     printf("\n");
//     for (int i=0;i<12;i++){
//        printf("%c\t",c[i]);
//    }
//    printf("\n");
//    if (c[11]==NULL) printf("This is correct!!!");
//    else printf("this is incorrect!!!!");

  // getchar();
   return 0;

}