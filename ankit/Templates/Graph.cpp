#include<map>
#include<iostream>
using namespace std;

class Graph {
private:
	class List {
		private:
		class Node {
				private:
					int data;
					Node *next;
				public:
					Node(int d):data(d){}
					Node *getNext(){return next;}
					void setNext(Node *temp){ next=temp;}
					int getData(){ return data;}
		};
		Node *head;
		public:
			List(){
				head=NULL;
			}
			void addNode(int vertex) {
				if(head==NULL){
					head = new Node(vertex);
					head->setNext(NULL);
				}
				else {
					Node *temp=head;
					while(temp!=NULL) {

					}
				}
			}
	};
public:
	map<int,List*> aGraph;

	void addVertex(int vertex) {
		List *temp =new List();
		aGraph[vertex]=temp;
	}

	void addConnectingVertex(int vertex,int connVertex) {
		List *temp = aGraph[vertex];
		if(temp!=0) {
			temp->addNode(connVertex);
		}
		else {
			cout<<"vertex"<<vertex<<"does not exist in the graph";
		}
	}
};

int main() {
	Graph *g = new Graph();
	g->addVertex(1);
	g->addVertex(2);
	g->addConnectingVertex(1,2);

	return 0;
}
