new Promise(function(resolve,reject){
    console.log('promise')
    // reject('bye');
    setTimeout(function(){
        resolve('hello');
    },1000)
}).then(function(data){
    console.log('then : ' + data);
    // throw new Error();
    return data;
}).then(function(data){
    console.log('then : ' + data);
    return data;
}).catch(function(data){
    console.log('catch : '+data);
}).finally(function(data){
    console.log('finally');
    // console.log('finally : ' + data); finallyには引数は渡せない
})


console.log('global end');