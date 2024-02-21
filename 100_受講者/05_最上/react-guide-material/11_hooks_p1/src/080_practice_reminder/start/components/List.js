import Item from "./Item"
import {useTodos, useDispatchTodos } from "../context/TodoContext";

const List = () => {

    const todos = useTodos();
    const dispatch = useDispatchTodos();
  
    return (
        <div>
            {todos.map(todo =>(
            <Item todo={todo}  key={todo.id}/>
            ))}
        </div>
    );
}

export default List;