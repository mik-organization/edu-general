// 三項演算子（ ? : ）
// ?の前に条件式をその後ろにtrueだった時の処理 : の後ろにfalseだった時の処理
// 条件式 ? trueだった時の処理 : falseだった時の処理
const a = true;
let resultA = a ? 'true' : 'false';   //  下記のif文と同じ意味

// if(a) {
//   resultA = "true";
// } else {
//   resultA = "false";
// }
console.log(resultA);

function getResult() {
  return a ? "true" : "false";
}

console.log(getResult());
