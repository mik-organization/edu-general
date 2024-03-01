import test from "node:test";
import Hello, { Btn } from "./Hello"

const Example = () => {
  return (
    <>
    <Btn fn={(text) => console.log(`Hello ${text}`)}/>
    <Hello text = "TyepScript">Children</Hello>
    </>
  )
};

export default Example;
