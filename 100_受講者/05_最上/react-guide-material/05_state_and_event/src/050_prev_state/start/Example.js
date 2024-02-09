import { useState } from "react";

const Example = () => {
    let [ val, setVal ] = useState(0);

    const countUp = () => {
        setVal (val + 1);
        setVal (prevstate => {
            return prevstate+1
        })
      }
      const countDown = () => {
        setVal(val-1);
        return ;
      }
    
    return (
        <>
        <p>現在のカウント数: {val}</p>
        <button onClick = {countUp}>+</button>
        <button onClick = {countDown}>-</button> 
        
        </>
      )
};

export default Example;
