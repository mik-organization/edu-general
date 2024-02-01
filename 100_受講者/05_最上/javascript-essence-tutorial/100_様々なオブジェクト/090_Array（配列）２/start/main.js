const arry = [1, 2, 3, 4, 5];

arry.forEach(function(v, i, arry){
    console.log(v);
});

const newArry = arry.map(function(v, i, arry){      //iは要素番号
    console.log(v);
    return v*2;
    return arry;    //配列を配列にする

});

// console.log(arry);
// console.log(newArry);

const filterArry = arry.filter(function(v, i, arry){
   return i === 1; 
//    return arry; 
});

console.log(filterArry);

