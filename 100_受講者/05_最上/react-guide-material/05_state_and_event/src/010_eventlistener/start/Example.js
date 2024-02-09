const Example = () => {
  const clickHandler = () => {
    alert('ボタンがクリックされました。')
  }
  const clickHandler2 = () => {
    console.log('ボタンがクリックされました。')
  }

  const hello = () => 'hello react';

  return (
    <>
      {/* Cは大文字にする */}
      {/* 指定する関数に()をつけない、つけるとコードが読み込まれたときに実行されてしまう
      （画面が表示されたときにクリックせずにダイアログが表示される */}
      <button onClick = {clickHandler}>クリックしてね</button>   
      <button onClick = {clickHandler2}>クリックしてね</button>
      {hello()}
    </>
  );
};

export default Example;
