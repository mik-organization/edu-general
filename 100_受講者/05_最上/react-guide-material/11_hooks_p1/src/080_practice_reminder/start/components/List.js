import Item from "./Item"
import {useTodos} from "../context/TodoContext";

const List = () => {
    const todos = useTodos();
    return (
        <div>
            {todos.map((todo) =>(
            <Item todo={todo}  key={todo.id}/>
            ))}
        </div>
    );
}

export default List;