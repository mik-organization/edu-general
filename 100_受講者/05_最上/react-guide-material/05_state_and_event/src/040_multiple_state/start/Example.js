import { useState } from "react";

const Example = () => {
    let [ val1, setVal1 ] = useState(0);
    let [ val2, setVal2 ] = useState(10);
    let [ val3, setVal3 ] = useState(100);

    const clickHandlerA = () => setVal1(val1+1);
    const clickHandlerB = () => setVal2(val2+1);
    const clickHandlerC = () => setVal3(val3+1);
      
      return (
        <>
        <p>ボタンAを{val1}回押しました！</p>
        <button onClick = {clickHandlerA}>ボタンA</button> 
        
        <p>ボタンBを{val2}回押しました！</p>
        <button onClick = {clickHandlerB}>ボタンB</button> 
        
        <p>ボタンCを{val3}回押しました！</p>
        <button onClick = {clickHandlerC}>ボタンC</button> 
        </>
      )
};

export default Example;