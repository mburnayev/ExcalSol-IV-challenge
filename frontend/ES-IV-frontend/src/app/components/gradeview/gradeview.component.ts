import { Component, OnInit } from '@angular/core';
import { RouterOutlet, Router } from '@angular/router';
import { StudentService } from '../../services/student.service';

@Component({
    selector: 'app-gradeview',
    imports: [RouterOutlet],
    templateUrl: './gradeview.component.html',
    standalone: true
})
export class GradeviewComponent {
    constructor(private router: Router, private studentService: StudentService) { }

    ngOnInit(): void {
        // this.studentService.getStudent().subscribe
    }

    onSubmit(event: Event) {
        this.router.navigate([''])
    }
} 
