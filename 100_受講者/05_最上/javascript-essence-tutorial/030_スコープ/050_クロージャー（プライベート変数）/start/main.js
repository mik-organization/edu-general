function incrementFactory(){
    let num =  0;
    function increment(){
        num = num + 1;
        console.log(num);
    }

    return increment;
}

const  incremant = incrementFactory();

incremant();
incremant();
incremant();
incremant();


