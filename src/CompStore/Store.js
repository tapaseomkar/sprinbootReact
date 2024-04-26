import { combineReducers, Store } from "redux";
import { thunk } from "redux-thunk";
import logger from "redux-logger";
import { configureStore } from "@reduxjs/toolkit";
import Reducer from "../Redux/reducer";


const rootReducer=combineReducers({user:Reducer});
const store=configureStore({
    reducer:rootReducer,
    middleware:(getDefaultMiddleware) => getDefaultMiddleware().concat(thunk, logger)
});
export default store;
