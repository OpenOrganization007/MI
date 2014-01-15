#include<iostream>
using namespace std;

class Tv {
public:
    void turnon() {
        cout<<"turn on \n";
    }
    void turnoff() {
        cout<<"turn off \n";
    }
};

class Alarm {
public:
    void turnon() {
        cout<<"turn on \n";
    }
    void turnoff() {
        cout<<"tunr off \n";
    }
};

class Ac {
public:
    void turnon(){
        cout<<"turn on \n";

    }
    void turnoff() {
        cout<<"turn off\n";
    }
};


class HomeFascade {

private:
    Alarm a;
    Ac b;
    Tv c;
public:
    void goToWork(){
        a.turnoff();
        b.turnoff();
        c.turnoff();
    }

    void comeHome() {
        a.turnon();
        b.turnon();
        c.turnon();
    }

};


int main() {

    HomeFascade f;
    f.goToWork();
    f.comeHome();
return 0;
}
