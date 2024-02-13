import Profile from "./components/Profile.js";
const persons =[
  { name: "Geo", age: 18, hobbies:["sports", "music"] },
  { name: "Tom", age: 25, hobbies:["movie", "music" ] },
  { name: "Lisa", age: 21, hobbies:["sports", "travel", "game" ]}
]


const Example = () => {
  return (
    <>
      <h3>練習問題</h3>
      <p>Profileコンポーネントを使用して、完成コードと同じ画面を作成してください。</p>
      <p>また、Profileコンポーネント内のリスト表示部分にkeyを設定して、ワーニング表示がされないようにしてください。</p>
      <ul>
      {persons.map((person) => (
            /* リストにはkeyを設定することを忘れないように！ */
            <li key={person.name}>
            <Profile {...person} />
          </li>
           ))}
       {/* <li key = "hobby"> <Profile {...persons[0]}/></li>
       <li> <Profile {...persons[1]}/></li>
       <li> <Profile {...persons[2]}/></li> */}
      </ul>
    </>
  );
};

export default Example;
