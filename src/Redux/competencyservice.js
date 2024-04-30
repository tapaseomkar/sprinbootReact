import axios from 'axios';

const EMPLOYEE_BASE_REST_API_URL = 'http://localhost:4000/user/';

class CompetencyService{

    getAllEmployees(){
        return axios.get(EMPLOYEE_BASE_REST_API_URL)
    }

    getAllEmployeesUsers(){
        return axios.get(`http://localhost:4000/employee/`)
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

    login(email, password) {
        return axios.post('http://localhost:4000/manager/login', { email, password });
    }

    saveManager(managerData) {
        return axios.post(`http://localhost:4000/manager/save`, managerData);
      }

    // saveManager(managerData) {
    //     return axios.post(`http://localhost:4000/manager/save`, managerData, {
    //         headers: {
    //             'Content-Type': 'application/json'
    //         }
    //     });
    // }
    

}

export default new CompetencyService();