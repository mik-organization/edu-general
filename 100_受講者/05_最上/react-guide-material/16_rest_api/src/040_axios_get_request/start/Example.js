import { useEffect } from "react";
 import axios from "axios";

// axios でリクエスト送信
const Example = () => {
  useEffect(() => {
    const getUser = async() => {
      const res = await  axios.get('http://localhost:3003/user')
      console.log(res.data);
    }
    getUser();

    // axios.get('http://localhost:3003/user').then((res)=> {
    //   console.log(res.data);
    // });
  })
  return <></>;
};

export default Example;
