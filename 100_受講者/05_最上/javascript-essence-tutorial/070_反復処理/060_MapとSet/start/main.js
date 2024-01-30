const map =  new Map();
const key1 = {};

map.set(key1,'value1');
console.log(map.get(key1));

const key2 = function(){};
map.set(key2,'value2')
console.log(map.get(key2));

let key3;
map.set(key3 = 0,'value3');
console.log(map.get(key3));

map.delete(key3);
console.log(map.get(0));

//for of
for(const [k,v] of map){
    console.log(k,v);
}

//for in    mapは表示されない
for(const k in map){
    console.log(k);
}

const s = new Set();
s.add(key1);
s.add(key2);
s.add(key3);
s.delete(key3);

console.log(s.has(key3));   //審議値が返る

//配列に戻す
// const arry = Array = Array.from(s); 
const arry =[...s]; 
console.log(arry);

for(let k of s){
    console.log(k);
}