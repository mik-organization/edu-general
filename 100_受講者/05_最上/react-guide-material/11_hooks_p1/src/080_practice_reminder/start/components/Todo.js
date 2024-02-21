import {TodoProvider, useTodos, useDispatchTodos } from "../context/TodoContext";
import List from "./List"
import Form from "./Form"

const Todo = () => {

  const state = useTodos();
  const dispatch = useDispatchTodos();

  return (
      <TodoProvider>
        <List />
        <Form />
      </TodoProvider>
  )
};
export default Todo;
