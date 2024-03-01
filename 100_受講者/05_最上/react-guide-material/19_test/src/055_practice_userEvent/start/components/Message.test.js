import { render, screen } from "@testing-library/react";
import Message from "./Message";
import userEvent from "@testing-library/user-event";

/*
startフォルダ内にあるcomponentsフォルダにテストファイルを作成して、
Messageコンポーネントのテストをおこなってください。
テストは以下のQ1・Q2に従って作成してください。
Q1.画面内にinput要素が表示されていることをテストしてください。
Q2.input要素に値を入れると正しく値が更新されることをテストしてください。
*/
describe('Messageコンポーネントの動作確認', () => {
    describe('画面操作正常性確認', () => {
        test('input要素が表示されていること', () => {
            render(<Message />);
            const inputEl = screen.getByRole('textbox');
            expect(inputEl).toBeInTheDocument();
        });
    });

    describe('画面操作正常性確認', () => {
        test('入力値の挿入で値が更新される', async () => {
            const user = userEvent.setup();
            render(<Message />);
            const inputEl = screen.getByRole('textbox')

            expect(inputEl.value).toBe(""); 
            await user.type(inputEl, 'こんにちは');

            expect(inputEl.value).toBe('こんにちは');
        });  
    });  

});


//  模範解答
describe('Messageコンポーネントの動作確認', () => {
    describe('画面操作正常性確認', () => {
        test('input要素が存在するか', () => {
            render(<Message />);
            const inputEl = screen.getByPlaceholderText('メッセージを入力してください');
            expect(inputEl).toBeInTheDocument();
        });
    });

    describe('画面操作正常性確認', () => {
        test('inputのstateが更新され、値が正しく変更されているか', async () => {
            const user = userEvent.setup();
            render(<Message />);
            const inputEl = screen.getByRole('textbox')

            await user.type(inputEl, 'こんにちは');

            expect(inputEl.value).toBe('こんにちは');
        });  
    });  

});