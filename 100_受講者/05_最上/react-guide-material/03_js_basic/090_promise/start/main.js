//非同期処理(Promise)コードが書かれた順番に実行されないもの
let a = 0;
console.log(a);

new Promise ((resolve, reject) => {
    setTimeout(() => {  //2000ミリ秒(2秒)待った後にコールバック関数を実行する
        a = 1;
        resolve(a);      //thenメソッドが実行される
        // reject(a);       //catchメソッドが実行される
    }, 2000); 
}).then((b) => {
    console.log(b);
    return b             //returnは次のthenメソッドへ渡す
}).then((b) => {
    console.log(b);
}).catch((c) => {                   //catchのメソッドは何かしらのエラーが発生した時に使う
    console.log('catchが実行',c);
})


