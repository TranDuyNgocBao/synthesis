#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<conio.h>
#include<math.h>

//STRUCT danh sach
struct sinhvien{
    char ID[30];
    char name[50];
    char birth[30];
    char gender[30];
    char falcuty[30];
    char rating[30];
    char rank[30];
    int age;
    float GPA;
};

typedef struct sinhvien SV;

//******************************
//Khai bao Ham
void MENU(SV a[]);
void INPUT(SV a[], int* t);
void OUTPUT(SV a[],int* t);
void sort_name(SV a[], int *t);
void sort_GPA(SV a[], int *t);
int conti();
int search_Fal(SV a[],int* t);
void OUTPUT_(SV a[],int* check);
void delete_student(SV a[], int* t);
int STF(SV a[], int* t);
void RTF();
void Load_file(SV a[], int* t);
//*************************

int main()
{
    SV a[100];
    MENU(a);
    return 0;
}

//MENU
int m=0, file=0, n;
void MENU(SV a[])
{ 
	//Load_file(a,&n);
	system("cls");
    printf("||************* Functions of Program ***********||");
    printf("\n||          1. Input list of students           ||");
    printf("\n||          2. Print list of students           ||");
    printf("\n||          3. Sort by names                    ||");
    printf("\n||          4. Sort by GPAs                     ||");
    printf("\n||          5. Search by ID                     ||");
    printf("\n||          6. Delete student                   ||");
    printf("\n||          7. Save to files                    ||");
    printf("\n||          8. Open list from files             ||");
    printf("\n||          9. Load saved file to memory        ||");
    printf("\n||          0. Exit				||");
    printf("\n--------------------------------------------------");
    fflush(stdin);
    int check=0;
    do
    {
        printf("\nWhat function you want to choose (numbers from 1 to 9): ");
        fflush(stdin);
        scanf("%d", &check);
        switch (check)
        {
            case 1: 
                system("cls");
                file =0;
                printf("PLease input the number of students: ");
                scanf("%d", &n);
                INPUT(a,&n);
                printf("Input successful");
                m=1;
                printf("\nPress any key to continue");
                getch();
                MENU(a);
                break;
            case 2:
                if(m==1)
                {
                    system("cls");
                    printf("LIST OF STUDENTS\n \n");
                    OUTPUT(a,&n);
                    if(conti()==1)MENU(a);
                }
                else
                {
                    system("cls");
                    printf("List of students was not written yet, pls add list first");
                    printf("\nPress any key to continue");
                    getch();
                    MENU(a);
                }
                break;
            case 3:
                if(m==1)
                {
                    system("cls");
                    file =0;
                    sort_name(a,&n);
                    printf("Names are sorted successfully, print to see result");
                    printf("\nPress any key to continue");
                    getch();
                    MENU(a);
                }
                else
                {
                    system("cls");
                    printf("List of students was not written yet, pls add list first");
                    printf("\nPress any key to continue");
                    getch();
                    MENU(a);
                }
                break;
            case 4:
                if(m==1)
                {
                    system("cls");
                    file = 0;
                    sort_GPA(a,&n);
                    printf("GPAs are sorted successfully, print to see result");
                    printf("\nPress any key to continue");
                    getch();
                    MENU(a);
                }
                else
                {
                    system("cls");
                    printf("List of students was not written yet, pls add list first");
                    printf("\nPress any key to continue");
                    getch();
                    MENU(a);
                }
                break;
            case 5:
                if(m==1)
                {
                    file = 0;
                    int ch = search_Fal(a,&n);
                    if(ch == -1)printf("Cannot find the ID of student\n");
                    else OUTPUT_(a,&ch);
                    if(conti()==1)MENU(a);
                }
                else
                {
                    system("cls");
                    printf("List of students was not written yet, pls add list first");
                    printf("\nPress any key to continue");
                    getch();
                    MENU(a);
                }
                break;
            case 6:
                if(m==1)
                {
                    file = 0;
                    printf("Input the ID you want to delete:\n");
                    delete_student(a,&n);
                    if(conti()==1)MENU(a);
                }
                else
                {
                    system("cls");
                    printf("List of students was not written yet, pls add list first");
                    printf("\nPress any key to continue");
                    getch();
                    MENU(a);
                }
                break;
            case 7:
                if(m==1)
                {
                    system("cls");
                    int ch;
                    ch = STF(a,&n);
                    if(ch == 0)printf("Cannot open Files");
                    else{
                        printf("Sucessfully save lists to files\n");
                        file =1;
                    }
                    if(conti()==1)MENU(a);
                }
                else
                {
                    system("cls");
                    printf("List of students was not written yet, pls add list first");
                    printf("\nPress any key to continue");
                    getch();
                    MENU(a);
                }
                break;
            case 8:
                if(file == 0){
                    system("cls");
                    printf("Need to save file first\n");
                    if(conti()==1)MENU(a);
                }
                else if(file == 1)
                {
                    system("cls");
                    RTF();
                    printf("Press any key to continue\n");
                    getch();
                    if(conti()==1)MENU(a);
                }
                break;
            
			case 9:
				system("cls");
				Load_file(a, &n);
				printf("Loaded file successfully\n");
				m=1;
				printf("Press any key to continue");
				getch();
				MENU(a);
				break;
				
			case 0:
                system("cls");
                printf("SEE YOU AGAIN");
                exit(0);
                break;
				  
            default: 
                check=0;
                break;
        }
    }while(check==0); 
    return;
}

//***************************************
//TUoi
int AGE(char *s)
{
	int check =0,h=0;
	for(int i = 0; i<strlen(s); i++)
	{
		if(s[i]=='/' && check <2)check++;
		if(check ==2 && s[i]!='/')
		{
			h=h*10+(int) s[i]-48;
		}
	}
	return 2021-h;
}

// Xep loai
const char* RANK(float* s)
{
	if((float)0<=*s && *s<(float)6.5)return "Weak";
	else if(*s<(float)7.5)return "Normal";
	else if(*s<(float)8.5)return "Good";
	else if(*s <= (float)10)return "Excellent";
	else return "ERROR";
}

//Nhap
void INPUT(SV a[], int* t)
{
    for(int i=0; i<*t; i++)
    {
        //gets(a.name);
        printf("Student number %d\n", i+1);
        printf("Student ID: ");
    	fflush(stdin);
       		scanf("%[^\n]%*c", a[i].ID);
    	printf("Name: ");
        	scanf("%[^\n]%*c", a[i].name);
    	printf("Birthday (dd/mm/yy): ");
        	scanf("%[^\n]%*c", a[i].birth);
        	a[i].age=AGE(a[i].birth);
        	printf("Age: %d", a[i].age);
    	printf("\nSex: ");
        	scanf("%[^\n]%*c", a[i].gender);
    	printf("Falcuty: ");
        	scanf("%[^\n]%*c", a[i].falcuty);
    	printf("GPA score: ");
        	scanf("%f", &a[i].GPA);
        	strcpy(a[i].rank, RANK(&a[i].GPA));
        printf("Rank: %s\n", a[i].rank);
        printf("\n");
        printf("Press any keys to continue");
        getch();
        system("cls");
    }
      
    return;
}

//Xuat DS
void OUTPUT(SV a[],int* t)
{
    if(*t == 0)printf("List is empty\n");
    else{
    for(int i=0; i<*t; i++)
    {
        printf(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
        printf("No %d.", i+1);
        printf("\nStudent ID: %s", a[i].ID);
    	printf("\nName: %s", a[i].name);
    	printf("\nBirthday (dd/mm/yy): %s", a[i].birth);
        printf("\nAge: %d", a[i].age);
    	printf("\nSex: %s", a[i].gender);
    	printf("\nFalcuty: %s", a[i].falcuty);
    	printf("\nGPA score: %0.2f", a[i].GPA);
        printf("\nRank: %s", a[i].rank);
        printf("\n \n");
    }
    }
    return;
}

void OUTPUT_(SV a[],int* check)
{
    printf("No %d.", *check+1);
    printf("\nStudent ID: %s", a[*check].ID);
    printf("\nName: %s", a[*check].name);
    printf("\nBirthday (dd/mm/yy): %s", a[*check].birth);
    printf("\nAge: %d", a[*check].age);
    printf("\nSex: %s", a[*check].gender);
    printf("\nFalcuty: %s", a[*check].falcuty);
    printf("\nGPA score: %0.2f", a[*check].GPA);
    printf("\nRank: %s", a[*check].rank);
    printf("\n \n");
}

//SO sanh Names
int CP(char *a, char *b)
{
    int l1,l2;
    l1=strlen(a);
    l2=strlen(b);
    char c1,c2;
    for(int i=l1-1; i>=0; i--)
    {
        if(a[i-1] == ' ' || i-1<0)
        {
            c1 = a[i];
            break;
        }
    }
    for(int i=l2-1; i>=0; i--)
    {
        if(b[i-1] == ' ' || i-1<0)
        {
            c2 = b[i];
            break;
        }
    }
    if((int)c1>(int)c2)return 1;
    else if((int)c1<(int)c2) return 2;
    else return 0;
}

void sort_name(SV a[], int *t)
{
    SV tmp;
    int k;
    printf("Sort:\n");
    printf("1. From A-Z\n");
    printf("2. From Z-A\n");
    printf("Your choice: ");
    do{
    	fflush(stdin);
    	scanf("%d", &k);
	}while(k<1 || k>2);
    switch(k)
    {
    case 1:
		for(int i=0; i<*t-1;i++)
    	{
        	for(int j=i+1; j<*t; j++)
        	{
            	if(CP(a[i].name,a[j].name)==1)
            	{
                	tmp=a[i];
                	a[i]=a[j];
                	a[j]=tmp;
            	}
        	}
    	}
    	break;
	case 2:
		for(int i=0; i<*t-1;i++)
    	{
        	for(int j=i+1; j<*t; j++)
        	{
            	if(CP(a[i].name,a[j].name)==2)
            	{
                	tmp=a[i];
                	a[i]=a[j];
                	a[j]=tmp;
            	}
        	}
    	}
		break;	
	}
}

//SS diem
void sort_GPA(SV a[], int *t)
{
    SV tmp;
    int k;
    printf("Sort:\n");
    printf("1. From High to Low\n");
    printf("2. From Low to High\n");
    printf("Your choice: ");
    do{
    	fflush(stdin);
    	scanf("%d", &k);
	}while(k<1 || k>2);
    switch(k)
    {
    	case 1:
			for(int i=0; i<*t-1;i++)
    		{
        		for(int j=i+1; j<*t; j++)
        		{
           			if(a[i].GPA < a[j].GPA)
            		{
                		tmp=a[i];
                		a[i]=a[j];
                		a[j]=tmp;
            		}
        		}
    		}
    		break;
    	case 2:
    		for(int i=0; i<*t-1;i++)
    		{
        		for(int j=i+1; j<*t; j++)
        		{
           			if(a[i].GPA > a[j].GPA)
            		{
                		tmp=a[i];
                		a[i]=a[j];
                		a[j]=tmp;
            		}
        		}
    		}
    		break;
	}
}

//Tim kiem
int SS_str(char* a, char* b)
{
    if(strlen(a)!= strlen(b))return 0;
    for(int i=0; i<strlen(a); i++)
    {
        if(a[i]!=b[i])return 0;
    }
    return 1;
}
int search_Fal(SV a[],int* t)
{
    system("cls");
    char fal[30];
    printf("Input ID: ");
    fflush(stdin);
    scanf("%[^\n]%*c", &fal);
    int check =-1;
    for(int i =0; i<*t;i++)
    {
        if(check == -1)
        {
            if(SS_str(a[i].ID,fal) == 1)
            {
                check = i;
                break;
            }
        }
    }
    return check;
}

// Chon_tieptuc_hay_dung lai 
int conti()
{
    int k;
    printf("Choose\n 1-To continue\n 2-To exit\n");
    printf("Your choice: ");
    fflush(stdin);
    scanf("%d", &k);
    if(k==1)return 1;
    else
    {
        system("cls");
        printf("SEE YOU AGAIN");
        exit(0);
    }
}

// Xoa hoc sinh
void delete_student(SV a[], int* t)
{
    int ch;
    ch = search_Fal(a,t);
    if(ch == -1)printf("The ID of student is no longer existed\n");
    else{
        for(int i = ch; i<*t;i++)
        {
            a[i] = a[i+1];
        }
        *t = *t-1;
        printf("Sucessfully delete the Student, print to see result\n");
    }
}

// Save to FILE 
int STF(SV a[], int* t)
{
    FILE *fp;
    fp = fopen("danh_sach_SV.txt","w");
    if(fp == NULL){
        return 0;
    }

    if(*t == 0){
        fprintf(fp,"List is empty\n");
    }
    else{
    for(int i=0; i<*t; i++)
    {
        fprintf(fp,"No %d.", i+1);
        fprintf(fp,"\nStudent ID: %s", a[i].ID);
    	fprintf(fp,"\nName: %s", a[i].name);
    	fprintf(fp,"\nBirthday (dd/mm/yy): %s", a[i].birth);
        fprintf(fp,"\nAge: %d", a[i].age);
    	fprintf(fp,"\nSex: %s", a[i].gender);
    	fprintf(fp,"\nFalcuty: %s", a[i].falcuty);
    	fprintf(fp,"\nGPA score: %0.2f", a[i].GPA);
        fprintf(fp,"\nRank: %s", a[i].rank);
        fprintf(fp,"\n \n");
    }
    }
    fclose(fp);
    return 1;
}

// Read file
void RTF()
{
    FILE *fp;
    fp = fopen("danh_sach_SV.txt","r");
    if(fp == NULL){
        printf("Open file error\n");
    }
    else{
        char c;
        do{
            c=fgetc(fp);
            printf("%c", c);
        }while(c!=EOF);
    }
    fclose(fp);
}

//Load file
void Load_file(SV a[], int* t){
	FILE *fp;
    fp = fopen("danh_sach_SV.INP","r");
	fflush(stdin);
	fscanf(fp,"%d", &*t);
	for(int i=0; i<*t; i++)
    {
        //gets(a.name);
    		fflush(stdin);
       		char c;
       		c= fgetc(fp);
			if((int)c == 10)fscanf(fp,"%[^\n]%*c", a[i].ID);
    
        	if((int)c == 10)fscanf(fp,"%[^\n]%*c", a[i].name);
    
        	if((int)c == 10)fscanf(fp,"%[^\n]%*c", a[i].birth);
        	a[i].age=AGE(a[i].birth);
        
        	if((int)c == 10)fscanf(fp,"%[^\n]%*c", a[i].gender);
    
        	if((int)c == 10)fscanf(fp,"%[^\n]%*c", a[i].falcuty);

        	if((int)c == 10)fscanf(fp,"%f", &a[i].GPA);
        	strcpy(a[i].rank, RANK(&a[i].GPA));
    }
    fclose(fp);
}