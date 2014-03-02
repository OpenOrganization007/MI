#include <iostream>

using namespace std;

void display(int arr[100])
{
    for(int i=0;i<100;++i)
    {
        
        if(arr[i]!=0)
        {cout<<arr[i];
            cout<<"\t";
        }
    }
    cout<<"\n\n";
}

int main()
{
   int arr[100];
   
   int i=0;
   
   for(i=0;i<100;++i)
   {
       arr[i]=i+1;
   }
   
   bool flag=1;
   int n=7;
   while(n)
   {
       n--;
       for( i=0;i<100;i++)
       {
           if(flag && arr[i]!=0)
           {
            arr[i]=0;
            flag=0;
           }
           else if(arr[i]!=0)
           {
               flag=1;
           }
       }
       display(arr);
       
   }
   
   return 0;
}
