import { useState } from "react";
import { HStack, Input, Button, useToast } from "@chakra-ui/react";

const Form = ({ createTodo }) => {
  const [enteredTodo, setEnteredTodo] = useState("");

  const toast = useToast();

  const addTodo = (e) => {
    e.preventDefault();

    if(!enteredTodo){
      toast({
        title: "新しいタスクを入力してください",
        status: "error",  //infoに変更すると青色のダイアログになる
        duration: 2000,   //どれくらいの間表示するか
        isClosable: true, //ダイアログに閉じるボタンを表示するかどうか
      });
      return;
    }

    const newTodo = {
      id: Math.floor(Math.random() * 1e5),
      content: enteredTodo,
    };

    createTodo(newTodo);

    setEnteredTodo("");

    toast({
      title: "新しいタスクを追加しました！",
      description: enteredTodo,
      status: "info",  
      duration: 3000,   //どれくらいの間表示するか
      isClosable: true, //ダイアログに閉じるボタンを表示するかどうか
    });
  };
  return (
    <form onSubmit={addTodo}>
    <HStack>
        <Input
          placeholder="新しいタスク"
          _placeholder={{opacity: "0.3", color: "gray.500"}}
          size="lg"
          bgColor="white"
          p={3}
          variant="flushed"
          value={enteredTodo}
          onChange={(e) => setEnteredTodo(e.target.value)}
        />
        <Button
          colorScheme="blue"
          size="md"
          bgColor="white"
          
          variant="outline"
          px={7}
          type="submit"
        >
        追加</Button>
    </HStack>
    </form>
  );
};

export default Form;
