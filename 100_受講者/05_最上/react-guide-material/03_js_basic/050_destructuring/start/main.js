const arry = ["配列1", "配列2", "配列3"];
console.log(arry[0]);
console.log(arry[2]);
//分割代入[]順番が大事
const [a, b, c] =  ["配列1", "配列2", "配列3"];
console.log(a);
console.log(c);


const obj = { x: "オブジェクト1", y: "オブジェクト2", z: "オブジェクト3" };
console.log(obj.x);
console.log(obj.z);
//分割代入(オブジェクトの場合){}でプロパティ名と一致させる必要がある
const {x, z} = { x: "オブジェクト1", y: "オブジェクト2", z: "オブジェクト3" };
console.log(x);
console.log(z);

//分割代入(関数)
const arr = ["Japan", "Tokyo", "Shinjuku"];
const objAddress = { country: "Japan", state: "Tokyo", city: "Shinjuku" };

const fnArr = (arry) => {
  console.log("---配列---");
  console.log(`country: ${arry[0]}`);
  console.log(`state: ${arry[1]}`);
  console.log(`city: ${arry[2]}`);
};
//分割代入(関数の配列)
const fnArr1 = ([ country, state, city ]) => {
  console.log("---配列---");
  console.log(`country: ${country}`);
  console.log(`state: ${state}`);
  console.log(`city: ${city} `);
};

const fnObj = (objAddr) => {
  console.log("---オブジェクト---");
  console.log(`country: ${objAddr.country}`);
  console.log(`state: ${objAddr.state}`);
  console.log(`city: ${objAddr.city}`);
};
//分割代入(関数のオブジェクト)
const fnObj1 = ({country, state, city}) => {
  console.log("---オブジェクト---");
  console.log(`country: ${country}`);
  console.log(`state: ${state}`);
  console.log(`city: ${city}`);
};

fnArr(arr);
fnArr1(arr);
fnObj(objAddress);
fnObj1(objAddress);
