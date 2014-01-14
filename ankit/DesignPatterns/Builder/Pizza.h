#ifndef Pizza_H
#define Pizza_H
#include<iostream>
#include<string>
using namespace std;
namespace Builder{
class Pizza {
    private:
    string dough ;
    string topping;
    string sauce;    

    public:
    
    void setDough(string d) {
        dough=d;
    }

    void setTopping(string t) {
        topping=t;
    }

    void setSauce(string s) {
        sauce=s;
    }

    void open() {
        cout<<"sauce"<<sauce<<"topping"<<topping<<"dough"<<dough;

    }
};
}
#endif
