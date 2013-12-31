#include<iostream>
using namespace std;

template<class T>
class Stack
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
Node *top;	
	
	
public:
	Stack<T>();
	void push(T data);
	T pop();		
};

template<class T>
Stack<T>::Stack()
{
	top = NULL;
}

template<class T>
void Stack<T>::push(T d)
{
	if(top ==NULL)
	{ 
		top = new Node(d);
		top->setNext(NULL);
	}
	else
	{
		Node *temp = new Node(d);
		temp->setNext(top);
		top=temp;
	}
}

template<class T>
T Stack<T>::pop()
{
	if(top == NULL) {
		cout<<"stack empty";
		return NULL;
	}
	else {
		Node *temp=top;
		top=top->getNext();
		T d = temp->getData();
		delete temp;
		return d;	
	}
}



int main(){
	Stack<int> s;
	s.push(4);
	s.push(5);
	cout<<s.pop()<<s.pop();
	return 0;
}
