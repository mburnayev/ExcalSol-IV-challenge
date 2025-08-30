import { Component } from '@angular/core';
import { RouterOutlet, Router } from '@angular/router';

@Component({
    selector: 'app-home',
    imports: [RouterOutlet],
    templateUrl: './home.component.html',
    standalone: true
})
export class HomeComponent {
    constructor(private router: Router) { }

    onSubmit(event: Event) {
        this.router.navigate(['/grades'])
    }
} 