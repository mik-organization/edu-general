import { useState } from "react";

const Example = () => {
  const [count, setCount] = useState({ val: 0 });

  console.log('re-render')

  const countUp = () => {
    setCount((prevstate) => {
      const newState ={...prevstate}
      newState.val += 1;
      // console.log(prevstate)
      return newState;
    });
  };

  return (
    <>
      <p>現在のカウント数: {count.val}</p>
      <button onClick={countUp}>+</button>
    </>
  );
};

export default Example;
