// asでこのファイル内で使用できる名前に変更できる
import defaultVal, { publicVal as val,publicFn as fn } from "./moduleA.js"; 
// import * as moduleA from './moduleA.js';
console.log(val); 
console.log(defaultVal); 
fn();
