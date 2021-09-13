const process = require('process')

class Profiler{
    constructor(label){
        this.label = label;
        this.time = null;
    }

    start(){
        this.time = process.hrtime();
    }

    end(){
        const diff = process.hrtime(this.time);
        console.log(`Timer: ${this.label} took ${diff[0]} seconds.`)
    }
}

function createProfiler(label){
    if(label === 'production'){
        return {start(){}, end(){}}
    }else{
        return new Profiler(label);
    }
}


//client code
let prodProfiler = createProfiler('production');
prodProfiler.start(); //nothing gets printed
prodProfiler.end(); //nothing gets printed

let devProfiler = createProfiler('dev');
devProfiler.start();
devProfiler.end();