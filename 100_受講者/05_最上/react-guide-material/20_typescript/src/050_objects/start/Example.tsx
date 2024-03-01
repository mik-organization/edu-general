const Example = () => {
  const arry1: number[] = [1, 2, 3];
  const arry2: String[] = ['hello', 'bye' ]
  const arry3: Array<number> = [1, 2, 3];
  const arry4: (string | number)[] = [1, 'bye'];
  const arry5: Array<string | number> = [1, 'bye'];

  type Person = { name: string , age?: number }   // ?を付けることによって任意の設定になる
  const obj1: Person = { name: 'Taro' };
  // obj1.name = 12   // 文字列以外を入れるとエラーになる
  // obj1.isMarried;   // 存在しないプロパティにアクセスしようとするとエラーになる

  const users: Person[] = [
    {name: 'Taro'},
    {name: 'Hanako', age: 30},
    {name: 'Jiro', age: 30},
    // {age: 20}  //nameプロパティがないのでエラー
  ] 

};

export default Example;
