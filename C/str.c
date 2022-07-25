#include <stdio.h>


int main()
{
    char s[20]="This is a test";
    int space_number=0; 
    for (int i=0; s[i]!='\0';i++) {
        if (s[i]==' ') space_number++;
    }
    printf("So luong space trong chuoi la: %d",space_number); 
    printf("%s",s);  // Thisisatest
}