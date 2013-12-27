#include <iostream>
#include <string>
using namespace std;

void Hanoi(string peg1 , string peg2 ,string peg3 ,int N) {
    if(N==1) {
        cout<<"move disc from "<<peg1<<"to"<<peg2<<"\n";
    }     
    else {
        Hanoi(peg1,peg2,peg3,N-1);
        Hanoi(peg1,peg3,peg2,1);
        Hanoi(peg2,peg3,peg1,N-1);
    }
}

int main()
{
   Hanoi("A","B","C",4);
   
   return 0;
}