import {useState} from "react";

const Example = () => {

  const [val, setVal] = useState("");
  const clearVal = () => setVal("");
  return (
    <>
    <p style={{ textAlign: "center" }}>
      startフォルダの内容が表示されます。
      <br />
      練習用に使ってください！
    </p>
    <div>
    {/* kabelのhtmlForとidの値を一緒にするとラベルをクリックしたらその入力フォームにフォーカスが当たる */}
    <label htmlFor="456">ラベル</label> 
    <div>
      <input
        id="123"
        placeholder="こんにちは"  //何も入力されていないときに表示される文字を指定できる
        value={val}
        onChange={(e)=>setVal(e.target.value)}
      />

      <textarea
        id="456"
        placeholder="こんにちは"
        value={val}             //入力したい値はここに記述
        onChange={(e)=>setVal(e.target.value)}
      />   
    </div>
    <h3>{val}</h3>
    <button onClick={clearVal}>クリア</button>
    </div>
    </>
  );
};

export default Example;
