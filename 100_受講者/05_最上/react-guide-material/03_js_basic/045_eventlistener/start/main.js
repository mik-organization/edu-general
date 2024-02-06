//htmlをjs内から操作するためのオブジェクトをDOMと呼ぶ

//htmlの操作や情報の取得に必要なものがプロパティの形式で格納取得できる
//取得してきたものをDOM,DOMオブジェクト,node,elementという
//htmlからh1タグを取得する
const h1Element = document.querySelector('h1');
console.log(h1Element);
console.dir(h1Element);

console.log(h1Element.textContent);
//h1の文字列を変更したい場合
h1Element.textContent = '変更後のタイトル';

//イベントリスナ
//画面の操作に応じて実行したい処理をイベントリスナに登録しておくことによって制御を加えることができる

//画面のボタンをクリックするとコンソールログにhelloと表示される
const btnEl = document.querySelector('button');
btnEl.addEventListener('click', (e)=>{           //第一引数にアクションtype、第二引数に実行したい関数
    console.log(e);     //  イベントのオブジェクトの形式の値が引数として渡されてくる
    console.dir(e.target);  //プロパティを指定することで情報を取得できる 
    console.dir(e.target.textContent); //buttonタグの文字列を取得できる
    console.log('hello');
} )  

const btnE2 = document.querySelector('button');
const helloFn =  (e)=>{    
    console.dir(e.target.textContent); //buttonタグの文字列を取得できる
} 
btnE2.addEventListener('click',helloFn);