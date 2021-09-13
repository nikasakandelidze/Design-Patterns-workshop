const process = require('process');

class MyPromise{
    constructor(executor){
        //properties
        this.successCallback = null
        this.resolved = false;
        this.resolvedValue = null;
        this.error = false;

        function resolve(value){
            this.resolved = true;
            this.resolvedValue = value;
        };

        function error(){
            this.resolved = true;
            this.error = true;
        };
        error = error.bind(this);
        resolve = resolve.bind(this);
        function tryToProcess(){
            process.nextTick(() => {
                if(this.resolved && this.error === false){
                    this.successCallback(this.resolvedValue);
                }else if(this.error === true){
                    this.failHandler();
                }else{
                    tryToProcess();
                }
            });
        };
        tryToProcess = tryToProcess.bind(this);
        tryToProcess();
        executor(resolve, error);
    }

    then(callback){
        this.successCallback = callback;
        return this;
    }

    failHandler(callback){
        this.failHandler = callback;
    }
}


let promise = new MyPromise((resolve, reject) => {
    // reject();
    resolve("hi from executor resolve");
}).then(result => console.log(result))
.failHandler(_=>console.log('error'));