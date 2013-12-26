#include <iostream>
#include <conio.h>
using namespace std;
#define DEFAULT -999



struct Node {
   int data;
   struct Node *next;
   struct Node *prevMin;

};

typedef struct Node Node;

struct Stack {
   Node *top;
   Node *min;
  
  
   Stack(){
      top = NULL;
      min = NULL;   
   }
   
   void push(int d) {
        Node *temp = new Node();
        temp->data =d;
        temp->next=NULL;
        cout<<"value inserted in stack"<<d<<"\n";
       
       if(top==NULL)
       {
          top=temp;
          min=temp;
          min->prevMin=NULL;
       }
       else 
       {
          temp->next=top;
          top=temp;
          if(min->data > top->data) {
              temp=min;             
              min=top;
              min->prevMin=temp;     
          }
       }
            
   }
  
   void pop() {
       if(top==NULL)
       {
           cout<<"Underflow No element in stack\n"; 
       }
       else
       {
           Node *temp = top;
           top=top->next;
           cout<<temp->data<<"deleted\n";
           if(min==temp)
           {
              min=min->prevMin;
    
           }
           delete temp; 

          
       }   
   }

   void minimum() {
        if(min) {
           cout<<"Minimum Value in stack"<<min->data<<"\n";
        }
        else {
           cout<<"Stack empty\n";
        }
  
   }
  
};

typedef struct Stack Stack;


Stack *S1;

int main () {

    S1 = new Stack();
    S1->push(7);
    S1->push(6);
    S1->push(4);
    S1->push(9);
    S1->minimum();
    S1->pop();
    S1->pop(); //pops 4 , hence a new minimum 6 should be there 
    S1->minimum();
    getch();
return 0;
}
