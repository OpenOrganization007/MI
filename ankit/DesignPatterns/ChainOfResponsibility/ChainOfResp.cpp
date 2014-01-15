#include <iostream>
#include <string>
using namespace std;

enum Responsibility{High,Medium,Low};

class Staff {
public:
    string name;
    Staff() {};
    Staff(string _name){
        name=_name;
    }
    virtual void setBoss(Staff *b) {};
    virtual void handle(Responsibility r)=0;
    ~Staff(){};
};

class Teacher : public Staff {
private:
Staff *boss;    
public:
    Teacher(string _name) {
        
    }
    
    void setBoss(Staff *b) {
        boss=b;
    }
    
    virtual void handle(Responsibility r) {
        if(r!=Responsibility::Low) {
            cout<<"the teacher will not handle this\n";
            if(boss) {
                boss->handle(r);
            }
        }
        else {
            cout<<"the teacher will handle this\n";
        }
    }

};

class Manager : public Staff {
private:
Staff *boss;   
public:
    Manager(string _name) {
       
    }
    
    void setBoss(Staff *b) {
        boss=b;
    }
    virtual void handle(Responsibility r) {
        if(r!=Responsibility::Medium) {
            cout<<"the manager will not handle this\n";
            if(boss) {
                boss->handle(r);
            }
        }
        else {
            cout<<"the manager will handle this\n";
        }
    }
};

class Director : public Staff  {
private: 
Staff *boss;
public:
    Director(string _name) {
        
    }    
    
    void setBoss(Staff *b) {
        boss=b;
    }
    
    virtual void handle(Responsibility r) {
        if(r!=Responsibility::High) {
            cout<<"the director will not handle this\n";
        }
        else {
            cout<<"the director will handle this\n";
        }
    }
};



int main()
{
   Staff *t=new Teacher("a");
   Staff *m = new Manager("b");
   Staff *d= new Director("d");
   
   t->setBoss(m);
   m->setBoss(d);
   
   t->handle(Responsibility::High);
   
   return 0;
}
