import React, { useState, useEffect } from 'react';
import CompetencyService from "../Redux/competencyservice";
import { Link } from 'react-router-dom';
import "../CssStyle/compcard.css";

const CompetencyCountCard = () => {
    const [competencyCount, setCompetencyCount] = useState(0);
    const [employeeCount, setEmployeeCount] = useState(0);

    useEffect(() => {
        fetchCounts();
    }, []);

    const fetchCounts = () => {
        CompetencyService.getcountOfCompetencies()
            .then((response) => {
                setCompetencyCount(response.data);
            })
            .catch((error) => {
                console.log(error);
            });

        CompetencyService.getcountOfEmployees()
            .then((response) => {
                setEmployeeCount(response.data);
            })
            .catch((error) => {
                console.log(error);
            });
    };

    return (
        <div className="card-container">
            <Link to="/complist" className="card competency-card">
                <div className="card-body">
                    <h5 className="card-title">Competency Count</h5>
                    <p className="card-text">{competencyCount}</p>
                </div>
            </Link>
            <Link to="/complist" className="card employee-card">
                <div className="card-body">
                    <h5 className="card-title">Employee Count</h5>
                    <p className="card-text">{employeeCount}</p>
                </div>
            </Link>
        </div>
    );
};

export default CompetencyCountCard;