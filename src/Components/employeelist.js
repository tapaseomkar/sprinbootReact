import React, {useState, useEffect} from 'react'
import CompetencyService from "../Redux/competencyservice"
import "../CssStyle/comlist.css";


const EmployeeList = () => {
    const [employeelist, setemployeelist] = useState([])

    useEffect(() => {
        getAllEmployees();
    }, [])

    const getAllEmployees = () => {
        CompetencyService.getAllEmployeesUsers().then((response) => {
            setemployeelist(response.data)
            console.log(response.data);
        }).catch(error =>{
            console.log(error);
        })
    }
    
    
   



    

     return (
        <div className="user-list-container">
          <h2>Employee List.....</h2>
          <div className="user-list-header">
            <div>ID</div>
            <div>Name</div>
            <div>Designation</div>
            <div>Email</div>
            <div>Irm</div>
          </div>
          {employeelist.map((employee) => (
            <div key={employee.id} className="user-item">
              <div>{employee.id}</div>
              <div>{employee.name}</div>
              <div>{employee.designation}</div>
              <div>{employee.email}</div>
              <div>{employee.irm}</div>
              <div className="user-item-actions">
              </div>
            </div>
          ))}
        </div>
      );
    };
    
    export default EmployeeList;