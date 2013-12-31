#include<iostream>
using namespace std;

template<class T>
class Queue
{
private:
	class Node {
		private:
			T data;
			Node *next;
		public:
			Node(T d):data(d){}
			Node *getNext(){return next;}
			void setNext(Node *temp){ next=temp;}
			T getData(){ return data;}
	};

	Node *front,*rear;

public:
	Queue():front(NULL),rear(NULL){}
	void insert(T data);
	T remove();
};

template<class T>
void Queue<T>::insert(T data){
	if(rear == NULL ){
	   front = new Node(data);
	   rear = front;
	   front->setNext(NULL);
	}
	else {
		Node *temp  = new Node(data);
		rear->setNext(temp);
		rear=rear->getNext();
	}
}

template<class T>
T Queue<T>::remove() {

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
	Queue<int> s;
	s.insert(4);
	s.insert(5);
	cout<<s.remove()<<s.remove();
	return 0;
}

