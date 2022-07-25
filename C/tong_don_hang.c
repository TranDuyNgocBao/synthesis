#include<stdio.h>

void char_input(void)
{
    char c;
    do {
        scanf("%c",&c);

    } while(c!='\n');
}

int get_input(void){
    int n;
    while (0==scanf("%d",&n))
    {
        char_input();
        printf("Invalid input. Pls reenter: ");
    }
    char_input();
    return n;
}

int main(){
    int tong = 0;
    int n;
    int q=0, gia=0;
    printf("So don hang la: ");
    n=get_input();
    if (n<=0) printf("invalid !!!\n");
    if (n>0){
        for (int i=1; i<=n;i++){
            printf("Don hang so %d\n",i);
            printf("So luong hang: ");
            q=get_input();
            printf("Don gia: ");
            gia=get_input();
            tong += q*gia;
        }
        printf("Tong tien la: %d \n", tong);
    } 
    return 0;
}