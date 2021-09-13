## Chain Of Responsibilities Pattern
    Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request.
     Chain the receiving objects and pass the request along the chain until an object handles it.
     
## General
    It helps to build a chain of objects. A request enters from one end and keeps going from an object to another until it finds a suitable handler.
       
## Example
    Servlet Filters in Java EE is an excelent example of chain of responsibilities.
