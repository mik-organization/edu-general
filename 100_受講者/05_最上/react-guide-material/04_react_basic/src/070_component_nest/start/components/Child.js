import "./Child.css";
import {List} from "./List.js";
const Child = () => {
  return (
    <div className="component">
      <h3>Hello Component</h3>
      <List />
    </div>
  );
};
//ul>li{item-$}*5 Tabキーで上記のコードが自動で書き込まれる
export default Child;
