import { useState } from "react";

const Example = () =>{
  const [toggle, setToggle] = useState(true);
  const toggleComponent = () => {
      setToggle(prev => !prev );    //元の値と逆の真偽値を返す
     
  }
  return (
    <>
    <button onClick={toggleComponent}>Toggle</button>
    {/* //同じステートメント内だと値が引き継がれてしまうのでkey属性を与えると別々のコンポーネントとして扱える */}
    {toggle ? <Count  key = "A"title="A"/> : <div><Count key ="B" title="B"/></div>} 
    {/* <Count title="A"/>
    {toggle && <Count title="B"/>} */}
     
    </>
  )
}
const Count = ({ title }) => {
  const [count, setCount] = useState(0);
  const countUp = () => {
    setCount((prevstate) => prevstate + 1);
  };
  const countDown = () => {
    setCount(count - 1);
  };
  return (
    <>
      <h3>{title}: {count}</h3>
      <button onClick={countUp}>+</button>
      <button onClick={countDown}>-</button>
    </>
  );
};

export default Example;
