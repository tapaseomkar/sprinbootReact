import { MAKE_REQUEST, FAIL_REQUEST, GET_COMPETENCY_LIST,ADD_COMPETENCY } from "./actiontype";

const initialState = {
  loading: true,
  Competencylist: [],
  userobj: {},
  errmessage: ""
};

export const Reducer = (state = initialState, action) => 
{
  switch (action.type) 
  {
    case MAKE_REQUEST:
      return {
        ...state,
        loading: false 
      };
    case FAIL_REQUEST:
      return {
        ...state,
        loading: false,
        errmessage: action.payload
      };
    case GET_COMPETENCY_LIST:
      return {
        ...state,
        loading: false,
        errmessage:"",
        Competencylist:  action.payload, // Update Competencylist array
        userobj: {} // Reset userobj
      };
    case ADD_COMPETENCY:
      return{
        ...state,
        Competencylist:[...state.Competencylist,action.payload],
        error:null
      };
    default:
      return state;
  }
};

export default Reducer;
