#include <stdio.h>
#include <string.h>
void get_string(char line[], int max); 
int main(){
    char name[100];
    printf("Enter your string: "); 
    gets(name);
    int i=strlen(name)-1;
 
}
    

void get_string(char line[], int max){
	int n = 0; 
	char c; 
	while ('\n' != (c = getchar())) 
	if (n < max) line[n++] = c; 
	line[n] = '\0'; 
}