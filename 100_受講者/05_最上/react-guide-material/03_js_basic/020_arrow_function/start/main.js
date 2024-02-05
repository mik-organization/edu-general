function fn(number) {
  return number * 2;
}
console.log(fn(2));
console.log(fn(4));


//引数が１つの時は()を省略できる,本文が一行の場合は{}とretrunを省略できる
const fnArrow = number => {
  console.log(number);
    return number*2;
}

//オブジェクトを戻り値として返したい場合は()で括る
const fnArrowObj = number => ({ reslut: number *2 })

console.log(fnArrowObj(2));