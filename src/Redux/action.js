import axios from "axios";
import { useReducer } from "react";
import { MAKE_REQUEST,FAIL_REQUEST, GET_COMPETENCY_LIST, ADD_COMPETENCY } from "./actiontype";


export const makeRequest=()=>{
    return{
        type:MAKE_REQUEST
    };
};


export const failRequest=err=>{
    return{
        type:FAIL_REQUEST,
        payload:err
    };
};

export const getcoompetencylist=data=>{
    return{
        type:GET_COMPETENCY_LIST,
        payload:data
    };
};

export const addcomp=user=>{
    return{
        type:ADD_COMPETENCY,
        payload:user
    };
};




// export const fetchCompetencyList=()=>{
//     return dispatch=>{
//         dispatch(makeRequest());
//         axios
//         .get("http://localhost:4000/user/")
//         .then(res=>{
//             const competencylist=res.data;
//             dispatch(getcoompetencylist(competencylist));
//         })
//         .catch(err=>{
//             dispatch(failRequest(err.message));
//         });
//     }
// }

export const addcomptolist=user=>{
    return dispatch=>{
        dispatch(makeRequest());
        axios
        .post("http://localhost:4000/user/add",user)
        .then(res=>{
            dispatch(addcomp(useReducer));
        })
        .catch(err=>{
            dispatch(failRequest(err.message));
        });
    };
}