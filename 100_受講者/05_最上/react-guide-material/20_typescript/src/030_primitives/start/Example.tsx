// プリミティブとは、TypeScriptが扱うことができる基本的な値のこと
// 具体的な例としては、文字列、数値、巨大な数値、真偽値、null、undefinedなどがある

const Example = () => {
  let str: string = 'Hello';
  str ='Bye';
  console.log(str);

  let num: number = 102;
  console.log(num);
  
  let bignum: bigint = 103n;
  console.log(bignum);
  
  let bool: boolean = true;
  console.log(bool);

  let nullish: null = null;
  let undefindValue: undefined = undefined;

  // リテラル型
  let tureVal: true = true;
  // tureVal = false;   //エラーになる

  let num123: 123 = 123;
  // num123 = 456;    // 123以外を入れるとエラーになる
  
  let strHello: 'Hello' = 'Hello';  //Helloのみを代入できる




};

export default Example;
