import React, {useState, useEffect} from 'react'
import { Link } from 'react-router-dom'
import CompetencyService from "../Redux/competencyservice"
import "../CssStyle/comlist.css";


const ListEmployeeComponent = () => {
    const [comp, setComp] = useState([])

    useEffect(() => {
        getAllCompetencies();
    }, [])

    const getAllCompetencies = () => {
        CompetencyService.getAllEmployees().then((response) => {
            setComp(response.data)
            console.log(response.data);
        }).catch(error =>{
            console.log(error);
        })
    }
    
    
    const removeEmployee = (userdeleteid) => {
       //console.log(userdeleteid);
       CompetencyService.deleteEmployee(userdeleteid).then((response)=>{
        getAllCompetencies();

       }).catch(error=>{
           console.log(error);
       })

     }



    

    return (
        <div className="user-list-container">
        <h2>COMPETENCT LIST.....</h2>
        <div className="user-list-header">
            <div>CompetencyName</div>
            <div>ManagerName</div>
            <div>Actions</div>
        </div>
        {comp.map((competency) => (
            <div key={competency.id} className="user-item">
                <div>{competency.name}</div>
                <div>{competency.managerName}</div>
                <div className="user-item-actions">
                  <Link to={`/view/${competency.id}`}><button>View</button></Link>
                     <button onClick={() => removeEmployee(competency.id)}>Delete</button> 
                     
                </div>
            </div>
        ))}
    </div>
    )
}

export default ListEmployeeComponent
