const arry = [10, 20, 30, 40];
const newArry = [];

for(let i = 0 ; i < arry.length ; i++){
    if(arry[i]*2 > 50){
        newArry.push(arry[i]*2);
    }
   
}
console.log(newArry);

// const newArry2 = arry.map(val => val*2);
// console.log(newArry2);
// const newArry3 = newArry2.filter(val => val > 50)
// console.log(newArry3);

const newArry2 = arry.map(val => val*2).filter(val => val > 50);
console.log(newArry2);  //実行結果： [60, 80]