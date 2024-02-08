import Profile from "./components/Profile";
import Container from "./components/Container";

const profile = [
  { name: "Takashi", age: 19, country: "Japan", color: "blue" },
  { name: "Jane", age: 28, country: "UK", color: "red" },
];

const Example = () => {
  return (
    <div>
        <Container title="Childrenとは？"  children={
          [
            <Profile key={profile[0].name} {...profile[0]}/>,
            <Profile key={profile[1].name} {...profile[1]}/>
          ]
        }
        first = {<Profile key={profile[0].name} {...profile[0]}/>}
        second ={<Profile key={profile[1].name} {...profile[1]}/>}
        
        
        />
      {/* 上と同じ動きをする書き方 */}
      <Container title="Childrenとは？" >
        <Profile {...profile[0]}/>
        <Profile {...profile[1]}/>
      </Container>
    </div>
  );
};

export default Example;
