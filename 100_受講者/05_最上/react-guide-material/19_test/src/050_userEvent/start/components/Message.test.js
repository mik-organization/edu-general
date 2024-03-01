import { render, screen } from "@testing-library/react";
import Message from "./Message";
import userEvent from "@testing-library/user-event";


describe('Messageコンポーネントの動作確認', () => {
    describe('初期表示の正常性確認', () => {
        test('入力された文字が画面上に存在', () => {
            render(<Message />);
            const h2EL = screen.getByRole('heading', { nema: '入力された文字:'});
            expect(h2EL).toBeInTheDocument();
        });
    });

    describe('画面操作正常性確認', () => {
        test('入力値の変更 > 送信ボタン押下', async () => {
            const user = userEvent.setup();
            render(<Message />);
            const inputEl = screen.getByRole('textbox')
            const btnEl = screen.getByRole('button', { name: '送信ボタン' });
            const h2EL = screen.getByRole('heading', { nema: '入力された文字:'});

            expect(btnEl).toBeDisabled();  //ボタンが非活性かどうか確認
            expect(inputEl.value).toBe("");     //空文字かどうか確認

            await user.type(inputEl, 'こんにちは');
            expect(btnEl).not.toBeDisabled();

            await user.click(btnEl);  //ボタンが活性化されているかどうか確認
            expect(h2EL.textContent).toBe('入力された文字:こんにちは');


        });

    });

})