#include <iostream>

using namespace std;

class AbstractPlug {
public:    
    virtual void roundPin(){};
    virtual void pinCount(){};
};

class Plug:public AbstractPlug {
public:    
    void roundPin(){
       cout<<"This is a round pin\n";
    }
    void pinCount() {
        cout<<"This is a pin Count=2\n";
    }
    
};

class AbstractSwitchBoard {
public:
    virtual void flatPin() {};
    virtual void pinCount() {};
    
};

class SwitchBoard :public AbstractSwitchBoard {
public:
    void flatPin() {
        cout<<"this is a flat pin\n";
    }
    void pinCount() {
        cout<<"this is a pin count=3\n";
    }
};

class Adapter:public AbstractPlug {
private:
    AbstractSwitchBoard *T;
public:
    Adapter(AbstractSwitchBoard *TT) {
        T=TT;
    }
    void roundPin() {
        T->flatPin();
    }
    
    void pinCount() {
        T->pinCount();
    }
    
};

int main()
{
   SwitchBoard *m = new SwitchBoard();
   Adapter *a =new Adapter(m);
   a->roundPin();
   a->pinCount();
   delete a;
   delete m;
   
   return 0;
}
