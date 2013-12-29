#include <iostream>
#include <map>
using namespace std;

struct Node {
    int data;
    struct Node *next;
};

typedef struct Node Node;


Node *head = NULL;
void insert(int d);
void rem_duplicate_usingBuffer();
void rem_duplicate();
void display();



int main()
{
   insert(4);
   insert(3);
   insert(2);
   insert(3);
   insert(4);
   insert(7);
   
   display();
   
   
   rem_duplicate();
   display();
   
   
   
   
   return 0;
}

void insert(int d) {
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

}

void rem_duplicate_usingBuffer() {
    
    std::map<int,int> cntmap;
    std::map<int,int>::iterator it;
    Node *temp = head;
    while (temp) {
        it= cntmap.find(temp->data);
        if(it!=cntmap.end()) {
            cntmap[temp->data]++;        
        }
        else {
            cntmap[temp->data]=1;
        }
        temp=temp->next;
    }
    
    temp=head;
    Node *old=NULL;
    while (temp) {
        if(cntmap[temp->data]>1) {
            Node *delNode=temp;
            cout<<"deleting duplicate"<<temp->data<<"\n";
            if(head==temp) {
                head=head->next;
            }
            else {
                temp=temp->next;
                old->next=temp;
                cntmap[temp->data]--;
            }
            delete delNode;
        }
        else {
            old=temp;
            temp=temp->next;
        }
      
    }
}

void rem_duplicate() {
    Node *temp=head;
    Node *old=NULL;
    int checker = 0;
    int d;
    while(temp){
        d=temp->data;
        if( (checker & (1<<d)) > 0 ) {
            cout<<"deleting duplicate"<<temp->data<<"\n";
            Node *delNode = temp;
            old->next = temp->next;
            temp=temp->next;
            delete delNode ;
            
        }
        else {
            old = temp ;
            checker|=(1<<d);
            temp=temp->next;
            
        }
    }
}

void display() {
     Node *temp=head;
     while(temp) {
     cout<<"->"<<temp->data;
     temp=temp->next;
     }
     cout<<"\n";
}