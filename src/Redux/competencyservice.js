import axios from 'axios';


const EMPLOYEE_BASE_REST_API_URL = 'http://localhost:4000/user/';

class CompetencyService{

    getAllEmployees(){
        return axios.get(EMPLOYEE_BASE_REST_API_URL)
    }

    deleteEmployee(employeeId) {
        return axios.delete(`http://localhost:4000/user/${employeeId}`)
    }

    getEmployeesByCompetencyId(competencyId) {
        const url = `http://localhost:4000/employee/bycompetencyid/${competencyId}`;
        return axios.get(url);
    }

    getcountOfCompetencies() {
        const url = 'http://localhost:4000/user/count';
        return axios.get(url);
    }

    getcountOfEmployees() {
        const url = 'http://localhost:4000/employee/count';
        return axios.get(url);
    }


}

export default new CompetencyService();