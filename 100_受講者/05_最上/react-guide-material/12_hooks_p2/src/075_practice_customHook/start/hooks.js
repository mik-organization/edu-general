import { useState } from "react";

const useCount = () => {
    const [val, setVal] = useState(0);

    const count = () => {
      setVal(prev =>  prev+1);
    }

    return { val, count }
}

export default useCount;