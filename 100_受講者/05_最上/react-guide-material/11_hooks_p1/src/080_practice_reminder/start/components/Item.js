import { useState } from "react";
import { useTodos, useDispatchTodos } from "../context/TodoContext";

const Item = ({todo}) => {

    const [editingContent, setEditingContent ] = useState(todo.content);

    const state = useTodos();
    const dispatch = useDispatchTodos();

  

    const changeContent = (e) => setEditingContent(e.target.value);
    
    const toggleEditMode = () => {
        const newTodo = {...todo, edoting: !todo.edting};
        dispatch({type:'todo/update',todo: newTodo})
    }

    const confirmContent = (e) => {
        e.preventDefalut();
        const newTodo = {...todo, edoting: !todo.edting ,content: editingContent};
        dispatch({type:'todo/update',todo: newTodo})
    }
    const complete = (todo) => {
        dispatch({type: 'todo/delete',todo})
    }
    return (
        <div key={todo.id}>
        <form onSubmit={confirmContent} style={{display: 'inline'}}>

            <button onClick={() => complete(todo)}>完了</button>
            {
                todo.edting ? (
                    <input tyoe="text"
                    value={editingContent}
                    onChange={changeContent} />
                    ) : (
                        <span onDoubleClick={toggleEditMode}>{todo.content}</span>
                        )
                        
                    }
        </form>
            
              
        </div>
    )
}

export default Item;