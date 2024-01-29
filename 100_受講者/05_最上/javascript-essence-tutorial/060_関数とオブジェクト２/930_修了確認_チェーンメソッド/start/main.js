/**
 * 問題：
 * 電卓の入力と同じような挙動をするチェーンメソッド
 * を作成してみましょう。
 * 
 * 例えば、次のように使用し、結果が表示
 * されるようにします。
 * 
 * 
 * 例１）
 * const calc = new Calculator();
 * 
 * calc.set(10)
 * .minus()
 * .set(3) -> '7'を出力(10 - 3)
 * 
 * 例２）
 * const calc = new Calculator();
 * 
 * calc.set(10)
 * 	.minus()
 * 	.set(3) -> '7'を出力
 * 	.mutiply()
 * 	.set(6) -> '42'を出力（10 - 3) * 6
 */

class Calculator {
	constructor(num) {
		this.num = num;
	}
	set(num) {
		return this.num;
		}
	plus() {
		console.log(this.num + num);
		return this.num;
		}
	minus() {
		console.log(this.num + num);
		return this.num;
		}
	mutiply() {
		console.log(this.num + num);
		return this.num;
		}
	divide() {
		console.log(this.num + num);
		return this.num;
		}	

}

const calc = new Calculator();

calc.set(10)
	.minus()
	.set(3)
	.mutiply()
	.set(6)
	.divide()
	.set(2)
	.plus()
	.set(2)
