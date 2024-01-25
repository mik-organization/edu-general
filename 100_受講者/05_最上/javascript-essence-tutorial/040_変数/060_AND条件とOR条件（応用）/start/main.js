function hello(name){

    // if(!name){
    //     name = 'Tom';
    // }
    name = name || 'Tom';
    console.log('hello '+name);
}

//数値を引数で渡す場合は注意が必要
hello();

let name ;
// if(name){
//     hello(name)
// }

name && hello(name);