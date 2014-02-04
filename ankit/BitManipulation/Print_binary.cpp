#include <iostream>
#include <vector>
using namespace std;

void print_binary(int n );

int main()
{
   print_binary(10);    
   return 0;
}


void print_binary(int n)
{
    int binary[10];
    int k=0;
    int i=-1;
    while(n!=0){
        k=n%2;
        n=n/2;
        binary[++i]=k;
    }
    
    cout<<"the number is \n";
    for(int x = i ;x>=0;x--){
        cout<<binary[x];
    }
    
}
