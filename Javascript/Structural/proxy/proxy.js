class WebController{
    constructor(getHandler, postHandler){
        this.getHandler = getHandler;
        this.postHandler = postHandler;
    }

    get(){
        this.getHandler()
    }

    post(){
        this.postHandler()
    }
}


const log = (message) => console.log(message);

const webController = new WebController(()=>log('get method controller'), ()=>log('post method controller'));
const loggedWebController = new Proxy(webController, {
    get: (target, property) => {
        if (property === 'get'){
            return function(){
                log('logging get method')
                target.get()
            }
        }else if(property === 'post'){
            return function(){
                log('logging post method')
                target.post()
            }
        }
    }
});
loggedWebController.get();
loggedWebController.post();