#include<stdio.h>
#include<string.h>
#include<conio.h>
#include<stdlib.h>

int function1(char* a, char* b)
{
    int h, Pos, check;
    h = strlen(a);
    for(int i=0; i<strlen(b); i++)
    {
        if(a[0] == b[i])
        {
            int s = 0;
            check =1;
            for(int j = i; j< i+h; j++)
            {
                if(a[s]!=b[j])
                {
                    check =0;
                    break;
                }
                s++;
            }
        }
        if(check ==1){
            Pos = i;
            break;
        }
    }
    if(check ==1)return Pos;
    else return -1;
}

void function2(FILE *fp)
{
    int i=0, max =0, h, j=0;
    char c;
    do
    {
        c = fgetc(fp);
        if(((int)c == (int)'\n') || (c == EOF))
        {
           if(max < i)
           {
               max =i;
               h = j;
           } 
           j++;
           i=0;
        }else i++;
    } while (c != EOF);
    printf("%d %d",h,max);
}

int main()
{
    FILE *fp;
    fp = fopen("Test.txt","r");
    char k;
    printf("Choose a function: ");
    fflush(stdin);
    scanf("%c", &k);
    switch (k)
    {
        case '1':
            {
                char a[255];
                char b[255];
                fflush(stdin);
                fscanf(fp,"%[^\n]%*c",a);
                fscanf(fp,"%[^\n]%*c",b);
                printf("%d", function1(a,b));
                break;
            }
        case '2':
            function2(fp);
            break;
        case 'q':
            printf("SEE YOU AGAIN");
            exit(0);
            break;
    }
    return 0;
}