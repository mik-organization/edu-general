import functionB, { hello ,User} from "./module";
// import { User } from "./module.js";
//default exportの場合は{}は不要で好きな名前を定義することができる
// import functionB from "./module.js";

hello();
functionB();

const user = new User('Tom');
user.hello();