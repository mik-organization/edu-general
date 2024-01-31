function sleep(val) {
  return new Promise(function(resolve,reject) {
    setTimeout(function() {
      console.log(val++);
      // resolve(val);
      reject(val);
    }, val*500);
  });
}

//rejectが呼ばれるとcatchに処理が移る
// Promise.all([sleep(2),sleep(3),sleep(4)])
// .then(function(data){
//   console.log(data);
// }).catch(function(e){
//   console.log(e);
// });

//配列一つずつ処理が行われる
// Promise.race([sleep(2),sleep(3),sleep(4)]).then(function(data){
//   console.log(data);
// });

//rejectが呼ばれてもcatchに処理が移行しない
Promise.allSettled([sleep(2),sleep(3),sleep(4)])
.then(function(data){
  console.log(data);
}).catch(function(e){
  console.log(e);
});


// sleep(0).then(function(val) {
//   return sleep(val);
// }).then(function(val) {
//   return sleep(val);
// }).then(function(val) {
//   return sleep(val);
// })
