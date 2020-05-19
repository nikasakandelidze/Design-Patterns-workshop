Design Pattern: Prototype

Description:
In many cases It's frequently needed to create the exact same copy of one object,
Many developers use next steps:

   1)Instantiate new obj. of current type-->set Original objects field values to it-->Get cloned object(Exact same copy of original)

Correct,slick(And way better,easier) way to do it:
   1)Make current object's class implement "Clonable" interface

-----------------------------------------------------------------------------------------
In short, it allows you to create a copy of an existing object and modify it to your needs,
instead of going through the trouble of creating an object from scratch and setting it up.
-----------------------------------------------------------------------------------------

