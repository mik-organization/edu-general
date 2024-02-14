import { useState } from "react";

const Form = ({createTodo}) => {

    const [enteredTodo, setEnteredTodo] =useState("");

    const addTodo = (e) => {
        e.preventDefault(); //ブラウザのデフォルト動作が無効化される（画面が更新されない）
        const newTodo = {
            id: Math.floor(Math.random() * 1e5),    //0~1の値を小数点切り捨てで５乗した値をランダムに定義
            content: enteredTodo
        }

        createTodo(newTodo);

        setEnteredTodo("");

    }
    return(
        <div>
        <form onSubmit={addTodo} >
         <input type ="text"
        value={enteredTodo}
        onChange={(e)=>setEnteredTodo(e.target.value)}
      />
      <button>追加</button>
      </form>
    </div>
    )
}

export default Form;