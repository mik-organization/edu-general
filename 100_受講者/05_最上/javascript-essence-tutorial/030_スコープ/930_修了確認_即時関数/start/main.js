/**
 * 問題：
 * クロージャーの問題で作成した以下のcalcFactoryを即時関数
 * で書き直してみてください。

function calcFactory(val) {
    return {
        plus: function(target) {
            const newVal = val + target;
            console.log(`${val} + ${target} = ${newVal}`);
            val = newVal;
        },
        minus: function(target) {
            const newVal = val - target;
            console.log(`${val} - ${target} = ${newVal}`);
            val = newVal;
        },
        multiply: function(target) {
            const newVal = val * target;
            console.log(`${val} x ${target} = ${newVal}`);
            val = newVal;
        },
        divide: function(target) {
            const newVal = val / target;
            console.log(`${val} / ${target} = ${newVal}`);
            val = newVal;
        },
    }
}
const calc = calcFactory(10);
calc.plus(5);
calc.minus(3);
calc.multiply(3);
calc.divide(2);
 */
const calc = (function calcFactory(){
    let val = 10;
    function plus(target) {
        const newVal = val + target;
        console.log(`${val} + ${target} = ${newVal}`);
        val = newVal;
    }
    function minus(target) {
        const newVal = val - target;
        console.log(`${val} - ${target} = ${newVal}`);
        val = newVal;
    }
    function multiply(target) {
        const newVal = val * target;
        console.log(`${val} x ${target} = ${newVal}`);
        val = newVal;
    }
    function divide(target) {
        const newVal = val / target;
        console.log(`${val} / ${target} = ${newVal}`);
        val = newVal;
    }
    return {
        plus,
        minus,
        multiply,
        divide
    };
}) ();
calc.plus(5);
calc.minus(3);
calc.multiply(3);
calc.divide(2);

const calc1 = (function (val){
    return {
        plus: function(target) {
            const newVal = val + target;
            console.log(`${val} + ${target} = ${newVal}`);
            val = newVal;
        },
        minus: function(target) {
            const newVal = val - target;
            console.log(`${val} - ${target} = ${newVal}`);
            val = newVal;
        },
        multiply: function(target) {
            const newVal = val * target;
            console.log(`${val} x ${target} = ${newVal}`);
            val = newVal;
        },
        divide: function(target) {
            const newVal = val / target;
            console.log(`${val} / ${target} = ${newVal}`);
            val = newVal;
        },
    }
})(10);
calc1.plus(5);
calc1.minus(3);
calc1.multiply(3);
calc1.divide(2);