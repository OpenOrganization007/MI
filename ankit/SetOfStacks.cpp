#include <iostream>
#include <conio.h>
using namespace std;
#define THRESHOLD 3



struct Node {
   int data;
   struct Node *next;
};

typedef struct Node Node;

struct Stack {
   Node *top;
   int count;
   Stack *nextStack;
  
  
   Stack(){
      top = NULL;
      count = 0;
   }
   
    int push(int d) {
        if(count<=THRESHOLD) {
            Node *temp = new Node();
            temp->data =d;
            temp->next=NULL;
            cout<<"value inserted in stack"<<d<<"\n";
            count++;
            if(top==NULL)
            {
              top=temp;
            }
           else 
           {
             temp->next=top;
             top=temp;
           }
           return 1;
        } 
        else 
        {
            return 0;
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
           count--;
           delete temp; 
       }   
   }
  
};


struct SetOfStacks {
   Stack *topS;

   void push(int d){
        if(topS == NULL)
        {
            topS = new Stack();
            topS->push(d);
        }
        else
        {
            if(!topS->push(d)) {
                Stack *temp = new Stack();
                temp->push(d);
                temp->nextStack=topS;
                topS=temp;
            }
        }
   }
   
   void pop() {
        if(topS->top!=NULL) {
             topS->pop();
        }
        else {
             Stack *temp = topS;
             topS = topS->nextStack;
             delete temp;
             if(topS) {
                 topS->pop();
             }
             else {
                 cout<<"no element in stack\n";
             }
        }
   }

   void popAtIndex( int index ) {
        Stack *temp=topS;
        for(int i=1;i<=index ; i++) {
               if(temp){
                  temp=temp->nextStack;
               } 
               else {
                   cout<<index<<"Stack does not exist\n";
                   return;
               }
        }
        if(temp) {
            temp->pop();
        }
         
   }
    
};
typedef struct SetOfStacks SetOfStacks;

int main() {
    
    SetOfStacks *S1 = new SetOfStacks();
      S1->push(7);
      S1->push(6);
      S1->push(4);
      S1->push(9);
      S1->push(117);
      S1->push(16);
      S1->push(14);
      S1->push(19);
      S1->popAtIndex(1);
      getch();
    return 0;

}
