function createPerson(name){
    const privateProperties = {};

    const person = {
        setName(name){
            if(!name){
                throw new Error('A person must have name');
            }
            privateProperties.name = name;
        },
        getName(){
            return privateProperties.name;
        }
    };

    person.setName(name);

    return person;
}


//client code
let person = createPerson('nika');
// console.log(person.name) !!undefined!! since person.name is encapsulated and only accessable through methods
console.log(person.getName());
// person.name = 'zoro';  //invalid!
console.log(person.getName());
person.setName('zoro');
console.log(person.getName())