// ユニオン型(union type)は複数の型を組み合わせて
// 「型Tまたは型U」のような、「または」の意味を表すことができる
// PONIT T｜U というように｜を用いてユニオン型を表す

const Example = () => {
  let strOrNum: string | Number = 'Hello';
  strOrNum = 123;
  console.log(strOrNum);

  let strOrNumOrBool: string | Number | boolean = 'Hello';
  strOrNumOrBool = true;
  console.log(strOrNumOrBool);
  
  let helloOrNumOrBool: 'Hello' | Number | boolean = false;

  type HelloOrNum = 'Hello' | Number;   // 独自の型を生成
  const hello: HelloOrNum = 'Hello';

  type DayOfWeek =
    | 'Monday'
    | 'Tuseday'

  const day: DayOfWeek = 'Monday';






};

export default Example;
