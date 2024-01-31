a();
function a(){
    console.log(c);
    let c = 5;
    d();
    function d(){

        console.log ('d is called');
    }
    console.log ('a is called');
}

//変数barは現在は非推奨
console.log(b);
var b = 0 ;

console.log(c);
let c = 1;

console.log(d);
const d = 1;


//関数式
x();
const x = function(){
    console.log(c);
    let c = 5;
    d();
    function d(){

        console.log ('d is called');
    }
    console.log ('a is called');
}
