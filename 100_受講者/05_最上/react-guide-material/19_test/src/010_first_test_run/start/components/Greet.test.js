import { render, screen } from "@testing-library/react";
import Greet from "./Greet";

it("h1が存在するかどうか", () => {
    render(<Greet />);
    const h1El = screen.getByText("こんにちは")
    expect(h1El).toBeInTheDocument();
})


// test('h1が存在するかどうか(失敗)', () => {
//     render(<Greet />);
//     const h1El = screen.getByText("こんばんは")
//     expect(h1El).toBeInTheDocument();
// })