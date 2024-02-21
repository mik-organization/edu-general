import Child from "./components/Child";
import { createContext } from "react";
export const MyContext = createContext('hello');

// useContext(アプリ全体で値を保持したいときに使用)
const Example = () => {
  // const value = 'hello'
  return <Child/>;
};

export default Example;
