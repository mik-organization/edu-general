const Example = () => {
  // 関数型（純粋関数）
  // ・fn(決まった引数) -> 決まった戻り値
  // ・関数外の状態（データ）は参照・変更しない。
  // ・関数外の影響を及ぼさない。
  // ・引数で渡された値を変更しない。(Immutability)
  // 上記の要件を満たさない操作を「副作用」と呼ぶ。

  const num = { val: 2 }
  const double = (num) => {
    const newNum = {val: num.val * 2};
    // newNum.val = num.val * 2;
    return newNum;
  } 

  const newNum = double(num);
  console.log('newNum',newNum,'num',num);
  console.log(newNum === num);

  return (
    <>
      <h3>不変性（Immutability）</h3>
      <p>引数で渡ってきたオブジェクトを変更しない！</p>
      <div>Immutability{}</div>
    </>
  );
};

export default Example;
