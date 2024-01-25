const a = 0;
const b = 1;
const c = 3;
const d = 0;

//falsyが見つかった時点で結果を返す、
//見つからないときは最後の値を結果として返す
console.log(a && b && c);
//truthyが見つかった時点で結果を返し
//見つからない場合は最後の値を結果として返す
console.log(a || b || c);

console.log((a || b) && c);
console.log((a || b) && (c || d));
