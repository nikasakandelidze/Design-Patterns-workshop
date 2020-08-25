Builder

## Definition:
            Seperate construction of a complex object from it's representation
            so that the same construction processes can create different representations.

## Used when creating complex(obj. with lots of arguments) objects


## Real life Example:
                   Imagine creating character of some game.You can choose default options for you character
                   but also you can customize each and every parameter of character creation/construction.


## Avoids constructor pollution and telescoping anti pattern

public Hero(String name,String Country,Object shiled,Object weapon,Integer height,Integer weight...) <---This is Bad
