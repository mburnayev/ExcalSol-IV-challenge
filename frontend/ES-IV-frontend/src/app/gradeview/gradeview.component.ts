import { Component, OnInit } from '@angular/core';
import { RouterOutlet, Router } from '@angular/router';

@Component({
    selector: 'app-gradeview',
    imports: [RouterOutlet],
    templateUrl: './gradeview.component.html',
    standalone: true
})
export class GradeviewComponent {
    constructor(private router: Router) { }

    ngOnInit(): void {
        // this.studentService.getStudent().subscribe
    }

    onSubmit(event: Event) {
        this.router.navigate([''])
    }
} 
