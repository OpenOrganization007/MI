#include <iostream>
#include <conio.h>
using namespace std;

#define MAX 52 

void define_limits();
int arr[MAX];
struct Stack {
   int top;
   int max_of_stack;
   int min_of_stack;
   
   void push(int d) {
       if(top<=max_of_stack)
       {
          arr[top++]=d;
          cout<<"value inserted in stack"<<d<<"\n";
       }
       else
       {
          cout<<"Overflow reached\n";
       }        
   }
  
   void pop() {
       if(top>=min_of_stack)
       {
           int d =arr[--top];
           cout<<"value"<<d<<"deleted from stack\n"; 
       }
       else
       {
          cout<<"Underflow No element in stack\n"; 
       }   
   }
  
};

typedef struct Stack Stack;


Stack *S1,*S2,*S3;


int main(){
   S1 = new Stack();
   S2 = new Stack();
   S3 = new Stack();

   define_limits();
   S1->push(5);
   S1->push(6);
   S1->push(7);

   S2->push(6);
   S2->push(76);
   S2->push(74);
   
   S3->push(69);
   S3->push(89);
   S3->push(73);

   S1->pop();
   S2->pop();
   S3->pop();

   getch();

   
   return 0;
}

void define_limits() {
    
      S1->max_of_stack = (MAX/3)-1 ;
      S2->max_of_stack = (2*MAX/3)-1;
      S3->max_of_stack = (MAX-1);
      S1->min_of_stack = 0;
      S1->top = 0;
      S2->min_of_stack = (MAX/3)+1;
      S2->top =(MAX/3)+1;
      S3->min_of_stack =(2*MAX/3)+1;
      S3->top =(2*MAX/3)+1;
}

