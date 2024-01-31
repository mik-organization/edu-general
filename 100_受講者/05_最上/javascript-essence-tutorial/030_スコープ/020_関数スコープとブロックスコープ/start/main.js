function a (){
    let b = 0;
    //こっちはOK
    console.log(b);
}
//変数が関数内（関数スコープ）のみで適用されるためエラー
//console.log(b);

a();

//ブロックスコープ(if{}やfor{}など)
{
    let c = 1;
    const d = 2;
    //varのみエラーが発生しないため非推奨
    var e = 3;
    console.log(c);
    console.log(d);

}
//変数がブロックスコープのみで適用されるためエラー
//console.log(c);
//console.log(d);
//console.log(e);


{
    function x (){
        console.log('x iss called');
    }
    x();
    
    const y = function(){
        console.log('y iss called');
        
    }
    y();
}

//関数宣言はブロックスコープ外でも使用できる
x();
//変数宣言の式ではエラー
y();

