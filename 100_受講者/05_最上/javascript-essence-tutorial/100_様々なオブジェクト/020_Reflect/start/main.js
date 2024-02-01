class C {
  constructor(a, b) {
    this.a = a;
    this.b = b;
  }
}

const obj1 = new C(1,2);
console.log(obj1);

const obj2 = Reflect.construct(C, [1,2]);
console.log(obj2);

console.log('c' in obj1);
console.log(Reflect.has(obj1,'a'));

// if(Reflect.defineProperty){

// }else{

// }

const bob = {
  name: 'Bob',
  _hello: function () {
    console.log(`hello ${this.name}`);
  }
}

const tom = {
  name: 'Tom',
  _hello: function () {
    console.log(`hello ${this.name}`);
  },
  get hello() {
    console.log(this);
    return this._hello();
  },
}
tom.hello;
Reflect.get(tom,'hello',bob)    //第三引数が省略された場合は第一引数と同じとされる