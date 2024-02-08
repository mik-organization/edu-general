import "./Child.css";
import React from "react";

const Child = () => {
  return (
    //key属性のみFragmentにつけることができる
    <React.Fragment>     
      <div className="component">
        <h3>Hello Component</h3>
      </div>
      <h3>Hello Fragment</h3>
      <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Hic quas nesciunt numquam aspernatur, saepe ipsam mollitia iusto amet nihil doloribus expedita, nobis distinctio, quo recusandae quod ut ipsa autem esse!</p>
    </React.Fragment>

  );
};

export default Child;
