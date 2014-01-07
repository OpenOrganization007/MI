#include<iostream>
using namespace std;

template<class T>
class PriorityQueue
{
private:
	class Node {
		private:
			T data;
			int priority;
			Node *next;
		public:
			Node(T d,int p):data(d),priority(p){}
			Node *getNext(){return next;}
			void setNext(Node *temp){ next=temp;}
			T getData(){ return data;}
			int getPriority(){ return priority; }
			void setPriority(int p){ priority=p; }
	};

	Node *front,*rear;
public:
	PriorityQueue():front(NULL),rear(NULL){}
	void insert(T data, int p);
	T remove();
};

template<class T>
void PriorityQueue<T>::insert(T data,int p){
	if(rear == NULL ){
	   front = new Node(data,p);
	   rear = front;
	   front->setNext(NULL);
	}
	else {
		Node *temp  = new Node(data,p);
		temp->setNext(NULL);
		
		Node *i= front;
		if( i->getPriority() < temp->getPriority()) {
			temp->setNext(front);
			front=temp;
		}
		else {
			while(i!=NULL) {
				if(i->getNext()!=NULL) {
					if( i->getPriority() < temp->getPriority() &&
						temp->getPriority() > i->getPriority() ) {
						temp->setNext(i->getNext());
						i->setNext(temp);
						break;
 					}
				}
				else {
					if( i->getPriority() < temp->getPriority()) {
						temp->setNext(i);
						rear = i;
						break;
					}
					else {
						rear=temp;
						i->setNext(temp);
						break;	
					}
				}	
				i=i->getNext();
			}
		}	
		rear->setNext(temp);
		rear=rear->getNext();
	}
}

template<class T>
T PriorityQueue<T>::remove() {

	if(front == NULL) {
		cout<<"queue empty";
		return NULL;
	}
	else {
		Node *temp=front;
		front=front->getNext();
		T d = temp->getData();
		delete temp;
		return d;
	}
}


int main(){
	PriorityQueue<int> s;
	s.insert(4,8);
	s.insert(5,3);
	s.insert(7,6);
	cout<<s.remove()<<s.remove();
	return 0;
}

