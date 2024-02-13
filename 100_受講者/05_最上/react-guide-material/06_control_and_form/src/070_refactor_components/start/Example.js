import { useState } from "react";
import AnimalList from "./components/AnimalList.js";
import AnimalFilter from "./components/AnimalFilter.js";
const Example = () => {
  const animals = ["Dog", "Cat", "Rat"];

  const [filterVal, setFilterVal] = useState("");
  const filterdAnimals = animals.filter((animal) => {
    const isMatch = animal.indexOf(filterVal) !== -1;
    return isMatch;
})

  return (
    <>
     <AnimalFilter filterState =  {[filterVal, setFilterVal]}/>
     <AnimalList animals={filterdAnimals}/>
    </>
  );
};

export default Example;
