// not proper check once again

#include <iostream>
using namespace std;

#define ANY 0
#define DOG 1
#define CAT 2


void TYPE(int x) {
     if (x==1) 
         cout<<"DOG";
     else
         cout<<"CAT";
}

struct Node {
  int data;
  struct Node *next;
};

typedef struct Node Node;

class Queue {
    
    private:    
    class Linklist {
        
        private :
            Node *head;
            Node *last;
        public :
           Linklist() {
               head=NULL;
               last=NULL;
           }
           void insert ( int d )
           {
                TYPE(d);
                cout<<"inserted\n";
                Node * temp = new Node();
                temp->data = d;
                temp->next = NULL;
               if(head==NULL) {
                  head=temp;
                  last=temp;
               }
               else {
                   
                   head->next=temp;
                   head=temp;
               }
           }
           
            
             void del(int animal) {
                   Node *temp = last;
                   Node *old=NULL;
                   animal = (animal==0)?( (temp)?(temp->data):(animal)):(animal);
             
                   while(temp!=NULL) {
                       if(temp->data == animal) {
                            TYPE(temp->data);
                            cout<<"deleted\n";
                            if(temp  == last) {
                               if(last == head ) {
                                    last = NULL;
                                    head = NULL;
                                                          
                               }
                               else {
                                   last=last->next;
                               }
                            }
                            else {
                                if(temp==head) {
                                    old->next=NULL;
                                }
                                else {
                                    old->next=temp->next;
                                }
                            }
                            delete temp;   
                       }
                       old = temp;
                   }
               }    
               
           void display() {
               Node *temp = last;
               while(temp)
               {
                   cout<<"->";
                   TYPE(temp->data);
                   
               }
           }
    };
    
    Linklist *LL ;
    
    public : 
    Queue() {
        LL=new Linklist();
    }
    
    void insertQ(int d)
    {
        LL->insert(d);
    }
    
    void getCatQ() {
        LL->del(CAT);
    }
    
     void getDogQ() {
        LL->del(DOG);
    } 
    
    void getAnyQ() {
        LL->del(ANY);
    }
    
    void show() {
        LL->display();
    }
    
};

int main() {
    
    Queue *q = new Queue();
    q->insertQ(DOG);
    q->insertQ(DOG);
    q->insertQ(CAT);
    q->insertQ(DOG);
    q->insertQ(DOG);
    q->show();
    
    /*
    q->getCatQ();
    q->show();
    
    q->getAnyQ();
    q->show();
    */ 
    
    return 0;
}