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
void display(Node * temp );
void del(Node *temp);
void rearrange(int x);
Node *find(int x);


int main()
{
    
    //inherrent flaw need to insert 4 
    // in the end and then check this
   insert(9);
   insert(3);
   insert(8);
   insert(6);
  
   insert(7);
   
   display(head); 

   rearrange(6);
   display(head);
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

void display(Node *temp ) {
    if(temp) {
        cout<<"->"<<temp->data;
        display(temp->next);
    }
    else {
        cout<<"\n";
    }
}


Node *find(int x) {
    Node *temp =head;
    while( temp ) {
        if(temp->data==x)
        return temp;
        
        temp=temp->next;
    }
    return NULL;
}

void rearrange(int x) {
    Node *Xnode= find(x);
    Node *curr, *old=NULL,*temp=head;
    bool flag=true;
    while(temp) {
            display(head);
            if(temp!=Xnode) {
                if(flag && temp->data >= x) {
                    cout<<"inserting "<<temp->data<<"in back of"<<Xnode->data<<"\n";
                    if(temp!=head)
                    {
                        curr=temp;
                        old=temp;
                        temp=temp->next;
                        curr->next=Xnode->next;
                        Xnode->next=curr;   
                    }
                    else {
                        curr=temp;
                        old=temp;
                        temp=temp->next;
                        head=head->next;
                        curr->next=Xnode->next;
                        Xnode->next=curr;
                        
                    }
                    
                }
                else if( !flag && temp->data < x) {
                    cout<<"inserting "<<temp->data<<"in front of"<<Xnode->data<<"\n";
                    curr=temp;
                    old->next=temp->next;
                    old=temp;
                    temp=temp->next;
                    curr->next=head;
                    head=curr;
                }
                else {
                    old=temp;
                    temp=temp->next;
                }
            }
            else {
                old=temp;
                temp=temp->next;
                flag=false;
            }
    }
}