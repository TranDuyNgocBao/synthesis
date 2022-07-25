#include <stdio.h>

#define PI 3.14   
#define NEWLINE '\n'

int main()
{
    const int diameter=10;
    float perimeter;  
  
    perimeter = diameter * PI;
    printf("Chu vi hinh tron co duong kinh %d la: %f", perimeter);
    printf("%c", NEWLINE);
    return 0;
}