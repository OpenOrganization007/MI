#include<iostream>
#include<string>
using namespace std;


class Car {
protected:
    string str;
public:
    Car() {
        str="unknowncar\n";
    }
    virtual void CarDescriptor() {
        cout<<str;
    }
    virtual ~Car() {
        
    }
    

};

class OptionsDecorator :public Car {
private:
    
public:
    OptionsDecorator() {};
    virtual void CarDescriptor() =0;
    virtual ~OptionsDecorator(){};
};

class CarModel1 :public Car {
private:
public:
       CarModel1() {
            str="Car Model 1\n";
            //cout<<"Car Model 1\n";
       }
    
        void CarDescriptor() {
            cout<<str;
        } 

};

class Navigation : public OptionsDecorator {
private:
    Car *b;
public:
        
      Navigation(Car * _b) {
        b=_b;
        str= "Navigation\n";
      }  

        void CarDescriptor() {
            b->CarDescriptor();
            cout<<str;
        }  
    

};

class Sound : public OptionsDecorator {
private:
    Car *b;
public:
        
      Sound(Car * _b) {
        b=_b;
        str= "Sound\n";
      }   

      void CarDescriptor() {
            b->CarDescriptor();
            cout<<str;
      }  

};


int main() {

    Car *b =new CarModel1();
    b->CarDescriptor();

    b = new Navigation(b);
    b->CarDescriptor();

    b = new Sound(b);
    b->CarDescriptor();

    return 0;
}
