let a = 0;
let a1 = 1;
let b = "";
let c = 0n;
let d = null;
let e = undefined;
let f ;
let g = parseInt("");//計算結果が数値として期待されるが数値として処理できなかった場合

console.log(Boolean(a));    //0はfalse
console.log(Boolean(a1));   //0以外の数値はtrue(1,20,300)
console.log(Boolean(b));
console.log(Boolean(c));
console.log(Boolean(d));
console.log(Boolean(e));
console.log(Boolean(f));
console.log(Boolean(g));

if(a){
    console.log("Hello");
}else{
    console.log("Bye");
}