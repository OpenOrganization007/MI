#include "Cook.h"
#include "PizzaBuilder.h"
#include "Pizza.h"
using namespace Builder;
#include <iostream>
#include <conio.h>
using namespace std;

int main() {
    Cook cook;
	PizzaBuilder* VegPizzaBuilder = new Builder::VegPizzaBuilder();
	PizzaBuilder* NonVegPizzaBuilder   = new Builder::NonVegPizzaBuilder();
 
	cook.setPizzaBuilder(VegPizzaBuilder);
	cook.constructPizza();
 
	Pizza* veg = cook.getPizza();
	veg->open();
 
	cook.setPizzaBuilder(NonVegPizzaBuilder);
	cook.constructPizza();
 
	delete VegPizzaBuilder;
	delete NonVegPizzaBuilder;
	delete veg;  
	getch();  
    return 0;
}
