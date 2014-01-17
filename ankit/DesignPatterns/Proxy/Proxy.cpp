#include <iostream>
using namespace std;

class Driver {
    public:
    int age;
    Driver(int a):age(a){}
};

class Icar {
    public:
    virtual void driveCar()=0;
    
};


class RealCar:public Icar {
    public:
    void driveCar() {
        cout<<"drive the car\n";
    }
};


class ProxyCar:public Icar {
    private:
    RealCar* car;
    Driver *driver;    
    
    public:
    ProxyCar(Driver *d) {
        driver=d;
        car=new RealCar();
    }
    void driveCar() {
        if(driver->age>=16) {
            car->driveCar();
        }
        else {
            cout<<"age is less than 16 can't drive car\n";
        }
    }
    
    
};





int main()
{
   Driver *d1 = new Driver(14);
   Driver *d2 = new Driver(17);
   
   Icar* ic1= new ProxyCar(d1);
   ic1->driveCar();
   
   Icar* ic2= new ProxyCar(d2);
   ic2->driveCar();
   
   return 0;
}
