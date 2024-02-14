import { useState } from "react"

const Example = () => {
    const [isSelected, setIsSelected] = useState(false);

    const clickHandler = () => setIsSelected(prev => !prev);

    const style = {
        width:120,
        height:60,
        display:"block",
        fontWeight:"bold",
        "border-radius":9999,   //50%でも同じ意味   //-は使えない
        cursor:"pointer",
        border: "none",
        margin: "auto",
        background: isSelected ? "pink" : ""
    }

    return (
        <>
            <button onClick={clickHandler} style={style}>ボタン</button>
            <div style={{ textAlign: "center"}}>{isSelected && "クリックされました。"}</div>
        </>
    )
};

export default Example;
