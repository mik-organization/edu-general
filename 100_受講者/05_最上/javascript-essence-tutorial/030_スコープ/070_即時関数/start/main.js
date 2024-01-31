function a (){
    console.log('called');
}
a();

let c = (function(){
    console.log('called');

    let privateVal = 0;
    let publicVal = 10;
    
    function privateFn(){
        console.log('praivateFn is called')
    }

    function publicFn(){
        console.log('publicFn is called'+privateVal++)
    }

    return {
        publicVal,
        publicFn
    };
})();

c.publicFn();
c.publicFn();
c.publicFn();
c.publicFn();
console.log(c.publicVal);

//外部になるのでエラー
//c.privateFn();
//console.log(c.privateVal);

let b =  function(){
    console.log('called');
}();