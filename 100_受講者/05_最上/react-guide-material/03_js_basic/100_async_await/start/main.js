// 非同期処理（await/async）
// Promiseをawait/asyncで書き直す方法
// await/asyncはセットで使う
// catchは例外処理try{}catch(){}の形で書く
let a = 0;

init()
async function init(){
    try{
        const result = await new Promise((resolve, reject) => {  //resolveの引数の値がresultに格納される
            setTimeout(() => {
                a = 1;
                // resolve(a)
                reject(a)
            }, 2000);
        })
            // console.log(a);
            console.log(result);
    }catch(e){
        console.log('catchが実行', e)
    }
}

// Promiseで書いた場合
// new Promise((resolve, reject) => {
//     setTimeout(() => {
//         a = 1;
//         resolve(a)
//     }, 2000);
// }).then((b) => {
//     console.log(b);
//     return b;
// }).then((b) => {
//     console.log(b);
// }).catch((c) => {
//     console.log('catchが実行', c)
// })

