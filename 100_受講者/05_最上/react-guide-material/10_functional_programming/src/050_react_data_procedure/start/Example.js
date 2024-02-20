import { useState } from "react";

/*
状態管理と保持
*/
const Example = () => {
  // JSXを作成する場所
  const [ state, setState ] = useState(0);
  const increment = () => {
    setState(state + 1);
  }
  return (
    <>
      <button onClick={increment}>+</button>
      <h3>{state}</h3>
    </>
  );
};

export default Example;
