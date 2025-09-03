// import axios from "axios"
// axios.defaults.headers.common["Acess-Control-Allow-Origin"] = "*";
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const API_URL = "https://localhost:8080"

@Injectable({
  providedIn: 'any'
})
export class StudentService {
    constructor(private http: HttpClient) {}

    getStudent(id: any) {
        return this.http.get(`${API_URL}/get/${id}`)
    }

    createStudent(student: any) {
        return this.http.post(`${API_URL}/post`, student)
    }
}
