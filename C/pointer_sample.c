#include<stdio.h>
int main() {
    int *p = NULL;
    int number = 50;
    int *p;
    p = &number; // luu tru dia chi cua bien number
    printf("Gia tri cua bien ma con tro chi toi la %d\n", *p);
    printf("Dia chi cua bien ma con tro chi toi %x\n", p);
    printf("Dia chi cua con tro la %x\n", &p);
    return 0;
}