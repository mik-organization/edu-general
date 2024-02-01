const wm = new WeakMap();   //for of は使えない

let o = {};
wm.set(o,'value1');

// o = null;
// o = {};
console.log(wm.get(o));
console.log(wm.has(o));
console.log(wm.delete(o));
console.log(wm.get(o));


