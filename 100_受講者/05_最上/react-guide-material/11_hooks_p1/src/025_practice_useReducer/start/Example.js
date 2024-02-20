import { useState, useReducer } from "react";

const CALC_OPTIONS = ["add", "minus", "divide", "multiply"];

const reducer = (prev, opt ) => {
  console.log(prev);
  console.log(opt);
switch (opt) {
  case "add":
    return  prev.a + prev.b;
  case "minus":
    return prev.a - prev.b;
  case "divide":
    return prev.a * prev.b;
  case "multiply":
    return prev.a / prev.b;
}
switch (prev) {
  case "a":
    return prev.a;
  case "b":
    return prev.b;
}}

const Example = () => {
  const initState = {
    a: 1,
    b: 2,
    result: 3,
  };

  const [state, dispatch] = useReducer(reducer, initState);
  // const [num, numDispatch] = useReducer(numReducer, initState);
 

  const calculate = (state) => {
    console.log(state.target.value)
    dispatch(state.target.value);
  };

  const numChangeHandler = ({num, name}) => {
    console.log(num)
    console.log(name)
    dispatch(num);
   
  };

  return (
    <>
    <h3>練習問題</h3>
    <p>useReducerを使って完成コードと同じ機能を作成してください。</p>
      <div>
        a:
        <input
          type="number"
          name="a"
          value={state.a}
          onChange={numChangeHandler}
        />
      </div>
      <div>
        b:
        <input
          type="number"
          name="b"
          value={state.b}
          onChange={numChangeHandler}
        />
      </div>
      <select value={state.type} onChange={calculate}>
        {CALC_OPTIONS.map(opt => <option key={opt} value={opt}>{opt}</option>)}
      </select>
      <h1>結果：{state.result}</h1>
    </>
  );
};

export default Example;
