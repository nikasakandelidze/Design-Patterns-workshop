const fs = require('fs')
const path = require('path');

// this demonstrates how require of CommonJs works under the hood.
// It is only for research purposes not for direct usage

//This function uses eval() functionality to read file with code.
function loadModule(fileName, module, require){
    const wrappedSrcCode = `
    (function(module, exports, require){
        ${fs.readFileSync(fileName, 'utf8')}
    })(module, module.exports, require)`;
    eval(wrappedSrcCode);
}

require.cache = {}
require.resolve = moduleName => {
    //Resolve full module name
    return path.join(__dirname, moduleName);
}

//This function has the same functionality as require() of CommonJs; 
function customRequire(moduleName){
    const id = require.resolve(moduleName)
    if(require.cache[id]){
        return require.cache[id].exports;
    }
    const module ={
        exports:{},
        id
    };
    require.cache[id] = module;
    loadModule(id, module, require);
    return module.exports;
}


//client code
const module1 = customRequire('module1.js');
const module2 = customRequire('module1.js');

console.log(module1 === module2);

console.log(module1.result);