import { add } from "./add"

const Example = () => {
    const dynamicInport = async() => {
         const module = await import("./add");
         console.log(module);
    }
    // import("./add").then(module => {
    //     console.log(module);
    // })
    // console.log(add(1, 2));
    dynamicInport();
  
};

export default Example;
