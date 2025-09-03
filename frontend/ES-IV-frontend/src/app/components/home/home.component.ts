import { Component, NgModule } from '@angular/core';
import { RouterOutlet, Router } from '@angular/router';
import { FormGroup, FormControl, NgModel, ReactiveFormsModule } from '@angular/forms'
import { IntegrationService } from '../../services/integration.service';
import { LoginRequest } from '../../models/login-request';

// @NgModule({
//     imports: [
//         ReactiveFormsModule
//     ]
// })
@Component({
    selector: 'app-home',
    imports: [RouterOutlet],
    templateUrl: './home.component.html',
    standalone: true
})
export class HomeComponent {
    constructor(private router: Router, private integration: IntegrationService) { }

    userForm: FormGroup = new FormGroup({
        username: new FormControl(''),
        password: new FormControl(''),
    })

    request: LoginRequest = new LoginRequest;

    doLogin() {
        const formValue = this.userForm.value;

        if(formValue.username == '' || formValue.password == '') {
            alert('Invalid credentials');
            return;
        }

        this.request.username = formValue.username;
        this.request.password = formValue.password;

        this.integration.doLogin(this.request).subscribe({
            next: (res) => {
                console.log("valid resp:" + res.token);
            }, error: (err) => {
                console.log("Error :(" + err)
            }
        })
    }

    onSubmit(event: Event) {
        this.router.navigate(['/grades'])
    }
} 