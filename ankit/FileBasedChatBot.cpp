#include <iostream>
#include <vector>
#include <string>
#include <sstream>
using namespace std;

typedef struct Node Node;

struct Node {
 long long data;
 bool inc;
 Node *left;
 Node *right;
 
};

Node *head=NULL;

Node *createBTree(Node *n,vector<long long>& arr , int size,int i){
  if(i>size-1) {
       n=NULL;
       return n;
   }
   else {
       if( arr[i]==-1 ) {
         n=NULL;
         return n;
       }
       else {
          n=new Node();
          if(head==NULL)
              head=n;
          n->data=arr[i];
          n->left = createBTree(n->left,arr,size,2*i+1);
          n->right = createBTree(n->right,arr,size,2*i+2);
          n->inc = false;
          //cout<<n->data<<"inserted\n";
          return n;
       }
   }
}


long long max( Node *n) {

//    cout<<"===================";
    if(n==NULL) {
       return 0;
    }    
    else if(n && n->left==NULL && n->right ==NULL) {
      // n->inc = true;
       return n->data;
    }    
    else if(n && n->left && n->right==NULL) {
 	   if(n->data > n->left->data){
		   n->inc = true;
		   return n->data;
	   }
	   else {
		 //
          n->left->inc = true;
		   return n->left->data;
	   }
       
    }
    else if(n && n->right && n->left==NULL) {
 
       if(n->data > n->right->data){
		   n->inc = true;
		   return n->data;
	   }
	   else {
		   n->right->inc = true;
		   return n->right->data;
	   }
  
    }
    else {
         long long ml = max(n->left);
         long long mr = max(n->right);
         if( n->left && n->left->inc == true && n->right && n->right->inc == true )
         {
			 if((n->data)>(ml+mr))
			 {
				 n->inc = true;
				 return n->data;
			 }
             else
             {
				 return ml+mr;
			 }				 
		 }   
		 if( n->left && n->left->inc == true && n->right && n->right->inc == false)
	     {
			 if((n->data+mr )>(ml))
			 {
				 n->inc =true;
				 return (n->data+mr);
			 }
			 else {
				 return ml;
			 }
		 }
		 if(n->right && n->right->inc == true && n->left && n->left->inc == false)
	     {
			 if((n->data+ml)>(mr))
			 {
				 n->inc =true;
				 return (n->data+ml);
			 }
			 else {
				 return mr;
			 }
		 }
     }
	return 0;
}

int main() {
	// your code goes here
	int T;
	vector<long long> arr;
	string s;
	cin>>T;
    int count=0;
    //int i=0;
	while(count!=T) {
		cin>>s;
		//cout<<s<<"\n";
		if(s=="#"){
			arr.push_back(-1);
		}
        else {
            istringstream buffer(s);
            long long value;
            buffer >> value; 
            arr.push_back(value);
            ++count;
        }
       // ++i;
	}
    head = createBTree(NULL,arr,arr.size(),0);
   cout<<max(head);
	return 0;
}
