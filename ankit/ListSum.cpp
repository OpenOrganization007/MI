#include <iostream>
#include <map>
using namespace std;

struct Node {
    int data;
    struct Node *next;
};

typedef struct Node Node;



Node* insert(int d, Node *);
void display(Node * temp );
Node *add(Node*,Node*);

int main()
{
    
   Node *num1=NULL,*num2=NULL,*sum=NULL;
   num1=insert(9,num1);
   num1=insert(3,num1);
   num2=insert(8,num2);
   num2=insert(6,num2);
   display(num1);
   display(num2);
   sum = add(num1,num2);
   display(sum);
   return 0;
}

Node *insert(int d ,Node *head) {
    Node *temp = new Node();
    temp->data=d;
    temp->next=NULL;
    if(!head) {
        head=temp;
    }
    else {
        temp->next=head;
        head=temp;
        
    }
    return head;

}

void display(Node *temp ) {
    if(temp) {
        cout<<"->"<<temp->data;
        display(temp->next);
    }
    else {
        cout<<"\n";
    }
}


Node *add(Node *num1,Node *num2) {
    Node *sum = NULL;
    Node *curr;
    int carry=0;
    while(num1 && num2) {
        Node *temp= new Node();
        temp->data = (num1->data + num2->data+carry)%10;
        carry=(num1->data + num2->data+carry)/10;
        temp->next=NULL;
        if(sum) {
             curr->next=temp;
             curr=curr->next;
        }
        else {
            sum=temp;
            curr=sum;
        }
        num1=num1->next;
        num2=num2->next;
    }
    if(num1) {
        
         while(num1) {
            Node *temp= new Node();
            temp->data= (num1->data+carry)%10;
            carry=(num1->data+carry)/10;         
            temp->next=NULL;
            curr->next=temp;
            curr=curr->next;
            num1=num1->next;
         }
    }
    else if(num2) {
        
        while(num2) {
            Node *temp= new Node();
            temp->data= (num2->data+carry)%10;
            carry=(num2->data+carry)/10;         
            temp->next=NULL;
            curr->next=temp;
            curr=curr->next;
            num2=num2->next;
         }
    }
    
    if(carry){
         
         
         Node *temp= new Node();
         temp->data=carry;
         temp->next=NULL;
         curr->next=temp;
         curr=curr->next;
    }
    return sum;
}


