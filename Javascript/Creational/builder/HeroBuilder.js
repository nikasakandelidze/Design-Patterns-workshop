class HeroBuidler{
    static create(){
        return new HeroBuidler();
    }

    withSword(sword){
        this.sword = sword;
        return this;
    }

    withArmor(armor){
        this.armor = armor;
        return this;
    }

    withName(name){
        this.name = name;
        return this;
    }

    withTransport(transport){
        this.transport = transport;
        return this;
    }

    build(){
        return new Hero({
            armor: this.armor,
            name: this.name,
            sword: this.sword,
            transport: this.transport
        });
    }
}

class Hero{
    constructor(allParameters){
        this.validate();
        this.armor = allParameters.armor;
        this.name = allParameters.name;
        this.sword = allParameters.sword;
        this.transport = allParameters.transport;
    }

    validate(){
        //check for mandatory fields
        if(!allParameters.name){
            throw new Error('Hero must have a name.');
        }
    }
}

//client code
let newHero = HeroBuidler.create()
                        .withArmor('armor')
                        .withName('nika')
                        .withSword('sword')
                        .build();
console.log(newHero.sword)
console.log(newHero.name)

//invalid input, no name specified
// let invalidHero = HeroBuidler.create().build(); 
