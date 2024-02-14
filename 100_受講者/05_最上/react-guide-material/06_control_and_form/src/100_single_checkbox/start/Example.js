import {useState} from "react";

const Example = () => {
  const [isChecked,setIsChecked] = useState(true);

  const toggleChecked = (e)=>{
    setIsChecked((prevState) => {
      let state = !prevState;
      return state;
    })
  }
  return (
    <>
    <p style={{ textAlign: "center" }}>
      startフォルダの内容が表示されます。
      <br />
      練習用に使ってください！
    </p>
    <div>
      <label htmlFor="my-check">
        チェック：
      </label>
      <input 
        type="checkbox"
        id="my-check"
        checked={isChecked}
        onChange={(e)=>toggleChecked(e)}
      />
      <div>{isChecked ? "ON!" : "OFF!"}</div>
    </div>
    </>
  );
};

export default Example;
