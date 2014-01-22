#ifndef PizzaBuilder_H
#define PizzaBuilder_H 
#include<iostream>
#include<string>
#include "Pizza.h"
namespace Builder {
class PizzaBuilder {
public:
    Pizza* mpizza;

public:

    Pizza* getPizza() {
         return mpizza;
    }

    void createNewPizzaProduct() {
         mpizza=new Pizza();
    }

    virtual void buildDough()=0;
    virtual void buildSauce()=0;
    virtual void buildTopping()=0;

    
};

class VegPizzaBuilder :public PizzaBuilder {
    virtual void buildDough() {
        mpizza->setDough("veg dough");
    }
    virtual void buildSauce() {
        mpizza->setSauce("tomato");
    }
    virtual void buildTopping() {
        mpizza->setTopping("onion and soya");
    }
};

class NonVegPizzaBuilder :public PizzaBuilder {
    virtual void buildDough() {
        mpizza->setDough("Nonveg Dough");
    }
    virtual void buildSauce() {
        mpizza->setSauce("fish");
    }
    virtual void buildTopping() {
        mpizza->setTopping("chicken");
    }
};
}
#endif
