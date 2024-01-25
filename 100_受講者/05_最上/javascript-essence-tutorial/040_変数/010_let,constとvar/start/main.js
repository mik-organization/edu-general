//再宣言できない
// let a = 0;
// let a = 1;

//再宣言できる
// var b = 0;
// var b = 1;
 
//再代入できる
let c = 0;
c = 1;

//constでは再代入できない
const d = 0;
d = 1;

//varはブロックスコープが無視される
{
    let e = 0;
    var f = 0;
}
//宣言前に値を取得しようとしたときに違いがある
console.log(g)
console.log(h)
let g = 0;
var h = 0;


