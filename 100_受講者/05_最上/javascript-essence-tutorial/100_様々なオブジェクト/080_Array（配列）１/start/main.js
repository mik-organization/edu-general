const arry = [1, 2, 3, 4, 5];
// const arry2 = arry.concat([6, 7, 8]);   //concatは引数の値を結合できる
const arry2 = [0, ...arry, 6, 7, 8];   //concatと同じ動きだが前方にも追加できるので使い勝手が良い
arry.push(6);
console.log(arry);

//popは配列の一番最後を削除
// const result = arry.pop();

//shiftは一番最初を削除
// const result = arry.shift();  

//unshiftは一番最初に引数を追加すし、追加後の配列の長さを返す
// const result = arry.unshift(0);   

//spliceは第一引数から第二引数までを切り取り、その値を返す。
//第三引数から後ろはその切り取った値に代入する値を指定することができる
const result = arry.splice(0,3,1,2);   

console.log(arry2,result);