Abstract FActory

Definition : Provide an interface/Abstract class for creating objects of related families without specifying their concrete classes.

Example :Smartphone Intereface toolkits that support multiple look-and-feel standarts,(Mobile software different themes),
         For one specific theme1 we have {buttons1,wallpaper1,scroll-bars1...}
         for another maybe theme2 we have {buttons2,wallpaper2,scroll-bars2...}


Example in this folder:

    AbstractBank and AbstractBankOffices are connected components(logically)
    AbstractFactory - interface that creates these logically connected components together.
    FactoryMaker - depending on argument creates concrete implementation of AbstractFactory
