import { useEffect, useState, useLayoutEffect } from "react";

const Example = () => {
  const [isDisp, setIsDisp] = useState(true);

  return (
    <>
      {isDisp && <Timer/>}
      <button onClick={() => setIsDisp(prev => !prev)}>{isDisp ? '非表示' : '表示'}</button>
     
    </>
  )
}

const Timer = () => {
  const [time, setTime] = useState(0);
  const [isRunnig, setIsRunnig] = useState(false);

  useEffect(() => {
    console.log('init');
    let intervalId = null;
    if(isRunnig){
      console.log('timer start')
      intervalId = window.setInterval(() => {
        console.log('interval running');
        setTime(prev => prev + 1);
      }, 1000);
    }
    return () => {
      window.clearInterval(intervalId)
      console.log('end');
    }
  }, [isRunnig])
  
  useEffect(() => {
    console.log('updated');
    
    document.title = 'counter:' + time;
    window.localStorage.setItem('time-key', time);

    return () => {
      // debugger
      console.log('updated end');
    }
  }, [time]);

  useLayoutEffect(() => {
    const _time = parseInt(window.localStorage.getItem('time-key'));
    if(!isNaN(_time)) {
      setTime(_time);
    }
  }, [])

  const toggle = () => {
    setIsRunnig(prev => !prev);
  }
  
  const reset = () => {
    setTime(0);
    setIsRunnig(false);

  }
  return (
    <>
    <h3>
      <time>{time}</time>
      <span>秒経過</span>
    </h3>
    <div>
      <button onClick={toggle}>{isRunnig ? '一時停止' : 'スタート'}</button>
      <button onClick={reset}>リセット</button>
    </div>
    
    </>
    );
};

export default Example;