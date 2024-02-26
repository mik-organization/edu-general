import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";

import { asyncCount } from "../../api/counter"

const counter = createSlice({
  name: 'counter',
  initialState: {
    count: 0,
    status: ''
  },
  reducers: {
    add(state, { type, payload }) {
      state.count = state.count + payload;
      // const newState = { ...state };
      // newState.count = state.count + payload
      // return newState;
    },
    minus(state, { type, payload }) {
      state.count = state.count - payload;
      // const newState = { ...state };
      // newState.count = state.count - payload
      // return newState;
    }
  },
  extraReducers: (builder) => {
    builder.addCase(addAsyncWithStatus.pending, (state) => {
      state.status = 'Loading...'   //実行中に表示(pending)
    })
    .addCase(addAsyncWithStatus.fulfilled, (state, action) => {
      state.status = '取得済み'     //実行後に表示(fulfilled)
      state.count = state.count + action.payload;
    })
    .addCase(addAsyncWithStatus.rejected, (state) => {
      state.status = 'エラー'   //非同期処理中にエラーが発生した場合(rejected)
    })

  }
});

const { add, minus } = counter.actions;

const addAsyncWithStatus = createAsyncThunk(
  'counter/asyncCount',
  async (payload) => {
    const response = await asyncCount(payload);
    return response.data;
  }
);
const addAsync = (payload) => {
  return async (dispatch, getState) => {
    const state = getState();
    console.log(state);
    const response = await asyncCount(payload);
    dispatch(add(response.data));
  }
}


export { add, minus, addAsync, addAsyncWithStatus }
export default counter.reducer