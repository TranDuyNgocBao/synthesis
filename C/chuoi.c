#include <stdio.h>
int main()
{
    char greetings_1[6] = {'H', 'e', 'l', 'l', 'o', '\0'};
    char greetings_2[] = "Hello";
    printf("%s\n",greetings_1);
    printf("%s\n",greetings_2);
}