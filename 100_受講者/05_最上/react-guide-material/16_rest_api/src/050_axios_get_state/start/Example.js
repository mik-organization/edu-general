import { useEffect, useState} from "react";
import axios from "axios";

const Example = () => {

  const [ users, setUsers ] = useState();

  useEffect(() => {
    const getUser = async () => {
      const res = await axios.get("http://localhost:3003/user");
      setUsers(res.data);
    }
    getUser();
  }, [])  // 空の配列を定義しないと無限ループになる

  return (
    <div>
      {users?.map(user => {
        
        return (
          <div key={user.id}>
            <h3>{user.username}</h3>
            <p>age:{user.age}</p>
            <p>hobby:{user.hobbies.join(',')}</p>
          </div>
        )
        }
         )}
    </div>
  )
  
};

export default Example;
