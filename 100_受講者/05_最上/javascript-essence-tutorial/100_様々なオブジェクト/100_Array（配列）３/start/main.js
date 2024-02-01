const arry = [1, 2, 3, 4, 5];

const result = arry.reduce(function(accu, curr){
    console.log(accu, curr);
    return accu + curr;
},0)                                            //第二引数を指定するとその値から乗算を開始する
console.log(result);