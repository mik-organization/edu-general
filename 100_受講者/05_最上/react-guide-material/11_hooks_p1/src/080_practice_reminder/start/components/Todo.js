import {TodoProvider} from "../context/TodoContext";
import List from "./List"
import Form from "./Form"

const Todo = () => {

  return (
      <TodoProvider>
        <List />
        <Form />
      </TodoProvider>
  )
};
export default Todo;
