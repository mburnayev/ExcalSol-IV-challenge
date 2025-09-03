import { Routes } from '@angular/router';
import { GradeviewComponent } from './components/gradeview/gradeview.component';
import { HomeComponent } from './components/home/home.component';

export const routes: Routes = [
    { path: "", component: HomeComponent },
    { path: "grades", component: GradeviewComponent },
    { path: "**", redirectTo: "" }
];
