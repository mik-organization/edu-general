import { useState } from "react";

const Example = () => {
  const animals = ["Dog", "Cat",null , "Rat"];

  const [filterVal, setFilterVal] = useState("");

  return (
    <>
      <input
        type="text"
        value={filterVal}
        onChange={(e) => setFilterVal(e.target.value)}
      />
      <ul>
        {animals
          .filter((animal) => {
            const animalStr = animal ?? "";
            const isMatch = animalStr.indexOf(filterVal) !== -1;
        
            return isMatch;
          })
          .map((animal) => {
            return <li key = {animal} >{
              //if文
              // if(animal === "Dog"){
              //   return <li key = {animal} >{animal + "★"}</li>
              // }else{
              //  return <li key = {animal} >{animal}</li>
              // }
              //3項演算子
              // animal +(animal === "Dog" 
              // ? "★" 
              // : "" )}</li> 
              //&&
              animal ?? "null,undefindでした。"
              }{animal === "Dog" && "★" }</li> 
              //??(Null合体演算子)
              //A ?? B
              //A null undefind
            
           
          }
            
        )}
      </ul>
    </>
  );
};

export default Example;
