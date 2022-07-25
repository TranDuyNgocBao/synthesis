#include <stdio.h>
int* sapxep(int *arr, int max){
    for (int i=0; i<max-1; i++)
        for (int j=i+1;j<max;j++)
            if (arr[i]>arr[j]){
                int t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
            }
    return arr;
}

// int arr[10]={1,4,5,-2,0,1};
// void sapxep(int max){
//     for (int i=0;i<max-1;i++)
//         for (int j=i+1; j<max; j++)
//             if (arr[i]>arr[j]){
//                 int t = arr[i];
//                 arr[i] = arr[j];
//                 arr[j] = t;
//             }
// }

int main(){
    int arr[10]={1,4,5,-2,0,1};
    int n=6;
    // sapxep(n);
    //for (int i= 0; i<n; i++) printf("%d ",arr[i]);
    // int co=0;
    // for (int i=0; i<n-1;i++)
    //     if (arr[i]+1 == (arr[i+1])){
    //         co=1;
    //         break;
    //     }
    // if (co==1) printf("Co 2 so lien ke trong mang \n");
    // else  printf("Khong co 2 so lien ke trong mang \n");
    
    int *p=sapxep(&arr[0],n);
    for (int i=0; i<n; i++) printf("%d ",*p++);
    printf("\n");
    return 0;

}