import { useState } from "react";

const Example = () => {
  const [fruits, setFruits] = useState([
    { label: "Apple", value: 100, checked: false },
    { label: "Banana", value: 200, checked: false },
    { label: "Cherry", value: 300, checked: false },
  ]);

  const [sum, setSum] = useState(0);

  const handleChange = (e) =>{
   const newFruits = fruits.map(fruits => {
      const newFruit = {...fruits};

      if(newFruit.label === e.target.value){
        newFruit.checked = !fruits.checked;
      }
      return newFruit;
    })

    setFruits(newFruits);

    
    // forEachを使った場合
    // let sumVal = 0;
    // newFruits.forEach(fruit => {
    //   if(fruit.checked){
    //     sumVal+=fruit.value;
    //   }
    // });

    // filterとforEachを使った場合
    // let sumVal = 0;
    // newFruits
    //   .filter(fruit => fruit.checked)   //fruitsのcheckedされているものを配列として取得
    //   .forEach(fruit => sumVal=+fruit.value)
   
    // filterとreduceを使った場合
    let sumVal = newFruits
      .filter(fruit => fruit.checked)   //fruitsのcheckedされているものを配列として取得
      .reduce((sumVal, fruit) => sumVal + fruit.value, 0);

    
    setSum(sumVal);
  }
  return (
    <div>
      {fruits.map(fruits => {
        return  (
            <div key={fruits.label}>
              <input
                id={fruits.label}
                type="checkbox"
                value={fruits.label}
                checked={fruits.checked}
                onChange={handleChange}
              />
              <label htmlFor={fruits.label}>
                {fruits.label}:{fruits.value}
              </label>
            </div>
        )
      })}
      
      <div>合計：{sum}</div>
    </div>
  );
};

export default Example;
