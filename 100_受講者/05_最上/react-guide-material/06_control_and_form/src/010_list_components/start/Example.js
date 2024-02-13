
const animals = ["Dog", "Cat", "Rat"];

const Example = () => {

  //for文を使った場合
  const animalList = [];
  for(const animal of animals){
    animalList.push(<li>{animal}</li>)
  }

  //mapを使った場合
  const helloAnimals = animals.map((animal) => <li>Hello, {animal}</li>);//式なのでJXS内に記述できる

  return (
    <>
      <h3>配列の操作</h3>
      <ul>
        {/* <li>{animals[0]}</li>
        <li>{animals[1]}</li>
        <li>{animals[2]}</li> */}
        {animalList}
        {helloAnimals}
        {animals.map((animal) => <li>Hello, {animal}</li>)}
      </ul>
    </>
  );
};

export default Example;
