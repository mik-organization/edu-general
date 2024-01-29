class Person{
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }

  hello() {
    console.log('hello ' + this.name);
  }
  
}

const bob = new Person('bob',23);
console.log(bob);

// function Person(name, age) {
//   this.name = name;
//   this.age = age;
// }

// Person.prototype.hello = function() {
//   console.log('hello ' + this.name);
// }