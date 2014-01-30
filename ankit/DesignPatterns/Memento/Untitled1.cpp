#include<iostream>
#include<math.h>
#include<conio.h>
#include<string>
using namespace std;

void swap(char *a,char *b);
void permutation( char arr[] , int i , int j);


int main(){

char arr[] = "abc";

permutation(arr,0,2);
    getch();
    return 0;
}

void swap(char *a,char *b)
{
    char *t;
    *t=*a;
    *a=*b;
    *b=*t;
}

void permutation( char *arr , int i , int j)
{
    if( i-j == 1 || i-j == -1)
    {
        cout<<arr[i];
    }

    else
    {
        char newarr[j];
        for(int x=i+1;x<=j;x++)
        {
            strcpy(newarr,arr);
            swap(&newarr[i],&newarr[x]);
            permutation(newarr,i+1,j);
        }    
    }
}
