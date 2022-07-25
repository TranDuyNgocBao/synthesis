#include<stdio.h>
 
void increase(int *num) {
    *num = *num + 1;
}
 
int main() {
    int x = 100;
    printf("Truoc khi goi phuong thuc x = %d \n", x);
    increase(&x); // truyen tham chieu vao phuong thuc
    printf("Sau khi goi phuong thuc x = %d \n", x);
    return 0;
}