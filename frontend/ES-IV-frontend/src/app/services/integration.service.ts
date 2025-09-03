import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { LoginResponse } from "../models/login-response";
import { LoginRequest } from "../models/login-request";

const API_URL = "https://localhost:8080/post"

@Injectable({
    providedIn: 'root'
})
export class IntegrationService {
    constructor(private http: HttpClient) {}

    doLogin(request: LoginRequest): Observable<LoginResponse> {
        return this.http.post<LoginResponse>(API_URL, request);
    }
}