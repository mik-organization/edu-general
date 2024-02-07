//スプレッド演算子(...)の使い方 
const nums = [3, 1, 4, 1, 5, 10, 2, 6];
//const result0 = Math.max(3, 1, 4, 1, 5, 10, 2, 6);
//関数の引数に配列の要素を展開して渡す時
//...によって配列が保持する要素が一つずつ展開される
const result = Math.max(...nums);
//console.log(result0);
console.log(result);

//元ある配列から新しい配列を作る時
let arr1 = [1, 2, 3];
let arr2 = [4, 5, 6];
let newArr = [...arr1, 10, ...arr2, 10];
let newArr1 = arr1;   //代入するのとスプレッド演算子でついかするのとはでは意味が異なる

console.log(newArr);
// console.log(newArr === arr1);   //false 異なる配列となる

//オブジェクトに対するスプレッド演算子
const obj = {
  name: "Tom",
  age: 22,
};
const newObj = { ...obj };
newObj.name = 'John'  //新しく定義したオブジェクトにのみ変更が適用される
console.log(newObj,obj);

//関数に対するスプレッド演算子
//渡ってきた引数を配列にする(残余引数)（レストパラメータ）
const restA = (...argA) => console.log(argA);
restA(1, 3, 4)

//特定の引数だけ別の変数にして定義をしたい場合
//一つ目の引数をnにしてそのほかを配列に格納
const restB = (n, ...argB) => console.log(argB);  //実行結果：[3, 4] 
restB(1, 3, 4)
