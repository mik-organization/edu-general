function hello(name){
    console.log('Hello ' + name);
}

function bye(){
    console.log('bye');
}

function fn(cb){
    cb('Tom');
}

fn(hello);
fn(bye);
fn(function(name){
    console.log('Hello '+name);
});

setTimeout(hello,2000);