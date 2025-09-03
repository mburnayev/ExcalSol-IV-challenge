import { Component } from '@angular/core';
import { RouterOutlet, Router } from '@angular/router';
import { FormGroup, FormControl, ReactiveFormsModule } from '@angular/forms'
import { HttpClient } from '@angular/common/http';

@Component({
    selector: 'app-home',
    imports: [RouterOutlet, ReactiveFormsModule],
    templateUrl: './home.component.html',
    standalone: true
})
export class HomeComponent {
    private API_URL = "http://localhost:8080"

    constructor(private router: Router, private httpClient: HttpClient) { }

    public signinData = new FormGroup({
        username: new FormControl(''),
        password: new FormControl('')
    });

    public signupData = new FormGroup({
        username: new FormControl(''),
        password: new FormControl('')
    });

    public handleSigninSubmit() {
        this.httpClient.get(`${this.API_URL}/check/${this.signinData.value.username}+${this.signinData.value.password}`).subscribe((data: any) => {
            if (data != null) {
                this.router.navigate(["/grades"]);
            } else {
                alert("Invalid credentials!");
            }
        });
    }

    public handleSignupSubmit() {
        this.httpClient.post(`${this.API_URL}/post`, { "username": `${this.signupData.value.username}`, "pwdhash": `${this.signupData.value.password}` }).subscribe((data: any) => {
            if (data != null) {
                this.router.navigate(["/grades"]);
            } else {
                alert("Account with this username already exists!");
            }
        });
    }
} 