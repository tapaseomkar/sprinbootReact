import React, { useState } from 'react';
import { connect } from 'react-redux';
import {addcomptolist} from "../Redux/action";
import "../CssStyle/compcreate.css";


const AddCompetencyForm = ({addcomptolist}) => {
    const[name,setName]=useState("");
    const[managerName,setManagerName]=useState("");

    const handleSubmit=(e)=>{
        e.preventDefault(); 
        addcomptolist({name,managerName});
        setName("");
        setManagerName("");
    };
   

    return (
        <div className="add-form-container">
            <h2>Add Competency</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label htmlFor="name">Competency Name:</label>
                    <input type="text" id="name" value={name} onChange={(e)=>setName(e.target.value)} required />
                </div>
                <div className="form-group">
                    <label htmlFor="managerName">Manager Name:</label>
                    <input type="text" id="managerName" value={managerName} onChange={(e)=>setManagerName(e.target.value)} required />
                </div>
                <button type="submit">Add Competency</button>
            </form>
        </div>
    );
};

const mapDispatchToProps=(dispatch)=>({
    addcomptolist: (user)=>dispatch(addcomptolist(user))
});

export default connect(null, mapDispatchToProps)(AddCompetencyForm);
