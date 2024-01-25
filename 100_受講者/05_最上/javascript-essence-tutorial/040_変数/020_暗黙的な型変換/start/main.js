function printTypeAndValue(val){
    console.log(typeof val,val);
}  

let a = 0;
printTypeAndValue(a);

let b = '1' + a;
//let b = parsInt('1') + a;
printTypeAndValue(b);

let c = 15 - b;
printTypeAndValue(c);

let d = c - null;
printTypeAndValue(d);

//数値との計算にtrueが使われた場合は数値１となる
let e = d - true;
printTypeAndValue(e);
