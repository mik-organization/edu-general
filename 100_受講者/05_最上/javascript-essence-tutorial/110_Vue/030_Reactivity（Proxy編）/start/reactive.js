const handler = {
  get(tagert, key, receiver){
    const res = Reflect.get(tagert, key, receiver);
    console.log('%c[reactive:get]','background: green; color: white;', key, res);
    return res; 
    
  },
  set(tagert, key, value, receiver){
    const res = Reflect.set(tagert, key, value, receiver);
    console.log('%c[reactive:set]','background: red; color: white;', key, value);
    trigger();
    return res; 
  }

}

function reactive(tagert){
  return new Proxy(tagert, handler);
}

let activeEffect = null;
function effect(fn) {
  activeEffect = fn;
}
function trigger() {
  activeEffect();
}
export { effect, trigger, reactive };