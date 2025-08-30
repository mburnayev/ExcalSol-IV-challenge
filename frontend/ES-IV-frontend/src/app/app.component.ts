import { Component } from '@angular/core';
import { RouterOutlet, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ES-IV-frontend';

  constructor(private router: Router) {}
  
  onSubmit() {
    this.router.navigate(["/grades"]);
  }
}
