// function* gen(){
//     yield 1;
//     yield 2;
//     return 3;
// }

// const it = gen();
// console.log(it.next());
// console.log(it.next());
// console.log(it.next());
// console.log(it.next());

function* genIterator(max = 10){
    let i = 0;

    while(i < max){
        yield i++;
    }
    return; //省略してもOk
}

const it = genIterator(10);

let a = it.next();
while(!a.done){
    console.log(a.value);
    a = it.next();
}

const obj = {
    *[Symbol.iterator](max = 10){
        let i = 0;
    
        while(i < max){
            yield i++;
        }
        return; //省略してもOk
    }
}

for(const i of genIterator()){
    console.log(i);
}