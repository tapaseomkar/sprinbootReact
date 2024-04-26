import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router';
import CompetencyService from "../Redux/competencyservice";
import "../CssStyle/emplist.css";

const ListEmployee = () => {
  const [comemployeelist, setemployeelist] = useState([]);
  const { id } = useParams();

  useEffect(() => {
    fetchEmployeeDetails(id);
  }, [id]);

  const fetchEmployeeDetails = (competencyId) => {
    CompetencyService.getEmployeesByCompetencyId(competencyId)
      .then((response) => {
        setemployeelist(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="user-list-container">
      <h2>Employee List.....</h2>
      <div className="user-list-header">
        <div>Name</div>
        <div>Designation</div>
        <div>Email</div>
        <div>Irm</div>
      </div>
      {comemployeelist.map((employee) => (
        <div key={employee.id} className="user-item">
          <div>{employee.name}</div>
          <div>{employee.designation}</div>
          <div>{employee.email}</div>
          <div>{employee.irm}</div>
          <div className="user-item-actions">
            {/* You can add buttons or other actions here */}
          </div>
        </div>
      ))}
    </div>
  );
};

export default ListEmployee;
