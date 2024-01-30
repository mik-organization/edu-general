// let a = (1 + 2 )*3;
let a = 0;
console.log(a);

let b ;
// let b = ++a;
// a = b = 1;

// let b = a++;
a = (b = a) +1 
console.log(a,b);

function fn(){
    let a = 0;
    return a++;
}
console.log(fn() * 5); 
console.log(!fn() * 5); // !0 * 5 型変換されて1 * 5になる
console.log(!(fn() * 5));  //true