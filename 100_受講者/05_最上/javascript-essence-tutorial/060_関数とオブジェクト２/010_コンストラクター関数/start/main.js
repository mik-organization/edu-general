//普通の関数と区別するためにコンストラクタ－関数は一文字目を大文字にする
function Person(name, age){
    this.name = name;
    this.age = age;

}

const  bob = new Person('Bob',18);
const  tom = new Person('Tom',33);
const  sun = new Person('Sun',20);