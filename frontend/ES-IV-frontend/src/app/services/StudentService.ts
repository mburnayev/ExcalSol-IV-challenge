import axios from "axios"
axios.defaults.headers.common["Acess-Control-Allow-Origin"] = "*";

const API_URL = "https://localhost:8080"

class StudentService {
    getStudent(id) {
        return axios.get(`${API_URL}/get/${id}`)
    }

    createStudent(student) {
        return axios.post(`${API_URL}/post`, student)
    }
}

export default new StudentService()