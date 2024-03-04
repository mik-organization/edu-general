import { useState } from "react";
import TaskList from "./TaskList";

export type Todo = {
    id: number,
    text: string
}

const Example = () => {

    const [ inputText, setInputText ] = useState("");

    const [ todos, setTodos ] = useState<Todo[]>([
        {id: 0, text: "Todo1"},
        {id: 1, text: "Todo2"}
    ]);

    const changeHandler = (e: React.ChangeEvent<HTMLInputElement>) => 
        setInputText(e.target.value);

    const addTodoItem = () => {
        setTodos(state => [...state, { id: state.length, text: inputText }])
        setInputText("");
    }
    
    return (
        <>
            <input type="text" value={inputText} onChange={changeHandler}></input>
            <button onClick={addTodoItem}>追加</button>
            <TaskList todos={todos} />
        </>
    )
};

export default Example;
