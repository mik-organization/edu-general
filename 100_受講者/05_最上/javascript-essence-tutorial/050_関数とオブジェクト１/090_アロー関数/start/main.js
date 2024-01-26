function a(name){
    return 'hello ' + name;
}

//無名関数をアロー関数に書き換える
const b = (name,name1) => 'hello ' + name +' '+ name1;

console.log(b('Tom','Bob'));