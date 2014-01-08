#include <iostream>
#include <conio.h>
using namespace std;

struct Node {
    int key;
    struct Node * left;
    struct Node * right;
    int height;
};

typedef struct Node Node;

int Height(struct Node *N) {
    if(N==NULL) {
        return 0;
    }
    return N->height;
}

int max(int a,int b) {
    return (a>b)? a:b;
}

Node* newNode(int key) {
    Node *aNode = new Node();
    aNode->key = key;
    aNode->height=1;
    aNode->left-NULL;
    aNode->right=NULL;
}

Node *rightRotate(Node *y) {

Node *x = y->left;
Node *T2 = x->right;

y->left = T2;
x->right = y;


y->height = max(height(y->left), height(y->right))+1;
x->height = max(height(x->left), height(x->right))+1;


return x;
}


Node *leftRotate(Node *x){

Node *y=x->right;
Node *T1 = x->left;

y->left = x ;
x->right = T1;

//  Update heights
x->height = max(height(x->left), height(x->right))+1;
y->height = max(height(y->left), height(y->right))+1;


return y;
}

int balance (Node *N)
{
         if (N == NULL)
        return 0;
    return height(N->left) - height(N->right);
}

struct node* insert(struct node* node, int key)
{
    /* 1.  Perform the normal BST rotation */
    if (node == NULL)
        return(newNode(key));
 
    if (key < node->key)
        node->left  = insert(node->left, key);
    else
        node->right = insert(node->right, key);
 
    /* 2. Update height of this ancestor node */
    node->height = max(height(node->left), height(node->right)) + 1;
 
    /* 3. Get the balance factor of this ancestor node to check whether
       this node became unbalanced */
    int balance = getBalance(node);
 
    // If this node becomes unbalanced, then there are 4 cases
 
    // Left Left Case
    if (balance > 1 && key < node->left->key)
        return rightRotate(node);
 
    // Right Right Case
    if (balance < -1 && key > node->right->key)
        return leftRotate(node);
 
    // Left Right Case
    if (balance > 1 && key > node->left->key)
    {
        node->left =  leftRotate(node->left);
        return rightRotate(node);
    }
 
    // Right Left Case
    if (balance < -1 && key < node->right->key)
    {
        node->right = rightRotate(node->right);
        return leftRotate(node);
    }
 
    /* return the (unchanged) node pointer */
    return node;
}

int main()
{
    // to do    
   
   return 0;
}
