import { useState } from "react";

const Example = () => {
  let [val, setVal] = useState();
  // console.log(valArry);
  return (
    <>
      <input
      type="text"
      onChange={(e) => {
        // const setFn = valArry[1];
        setVal(e.target.value);
        
       
      }}/> = {val}

        
        

    </>
  );
};
export default Example;
