import { useState } from "react";

const Example = () => {
  const personObj = { name: "Tom", age: 18 };
  const [person, setPerson] = useState(personObj);

  const changeName = (e) => {
  // setPerson({ name: e.target.value, age: person.age }) ;
  // 上記のコードと挙動が同じになる書き方...で元のもの入れて,の後ろで値を上書きすることができる。
  setPerson({ ...person, name: e.target.value }) ;
  };
  const changeAge = (e) => {
    setPerson({name: person.name,  age: e.target.value}) ;
    };
  const reset = () => {
    setPerson({name:"",  age:""}) ;
   
  };

  return (
    <>
    <h3>Name: {person.name}</h3>
    <h3>Age: {person.age}</h3>

    <input type="text" value={person.name} onChange={ changeName }></input>
    <input type="number" value={person.age} onChange={ changeAge }></input>

    <div>
      <button onClick = { reset }>リセット</button>
    </div>
    </>

  )
};

export default Example;
