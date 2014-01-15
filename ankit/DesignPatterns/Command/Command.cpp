#include<iostream>
using namespace std;

class Command {
    public:
        virtual void execute()=0;
};

class Light {
    public:
    void turnon(){
        cout<<"turn on\n";
    }
    void turnoff(){
        cout<<"turn off\n";
    }
};

class FlipUpCommand : public Command {
    private:
        Light light;
    public:    
        FlipUpCommand(){}
        FlipUpCommand(Light& l):light(l) {
            
        }
        virtual void execute() {
            light.turnon();
        }
    
};

class FlipDownCommand : public Command {
    private:
        Light light;
    public:
        FlipDownCommand(){}
        FlipDownCommand(Light & l):light(l) {
            
        }
        virtual void execute() {
            light.turnoff();
        }
};

class Switch {
    private:
    FlipUpCommand fuc;
    FlipDownCommand fdc;
    public:
    Switch(FlipUpCommand& _fuc,FlipDownCommand& _fdc) {
        fuc=_fuc;
        fdc=_fdc;
    }
    
    void flipUp() {
        fuc.execute();
    }
    
    void flipDown() {
        fdc.execute();
    }
    
    
};

int main() 
{
    Light lamp;
	FlipUpCommand switchUp(lamp);
	FlipDownCommand switchDown(lamp);
 
	Switch s(switchUp, switchDown);
	s.flipUp();
	s.flipDown();
    
    return 0;
}

