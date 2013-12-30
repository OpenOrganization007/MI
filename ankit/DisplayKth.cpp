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
void displayK(Node *, int);



int main()
{
   insert(4);
   insert(3);
   insert(2);
   insert(3);
   insert(4);
   insert(7);
   
   displayK(head,3);
   
   
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

void displayK(Node *temp,int k) {
    static int cnt =0 ;
    if(temp) {
        if(cnt<k) {
            cnt++;
            displayK(temp->next,k);
        }
        else {
            cout<<"->"<<temp->data;
            displayK(temp->next,k);
        }
    }
   
}