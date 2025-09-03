import { Component, Input } from '@angular/core';
import { RouterOutlet, Router, ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
    selector: 'app-gradeview',
    imports: [RouterOutlet, CommonModule],
    templateUrl: './gradeview.component.html',
    standalone: true
})
export class GradeviewComponent {
    public responseData: any;

    constructor(private router: Router, private route: ActivatedRoute) { }

    ngOnInit(): void {
        this.route.queryParams.subscribe(params => {
            if (params['data']) {
                this.responseData = JSON.parse(params['data']);
            }
        });
    }

    onSubmit(event: Event) {
        this.router.navigate([''])
    }
} 
