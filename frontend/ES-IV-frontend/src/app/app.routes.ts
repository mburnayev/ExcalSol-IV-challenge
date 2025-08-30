import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { GradeviewComponent } from './gradeview/gradeview.component';

export const routes: Routes = [
    {path: "", component: AppComponent},
    // {path: "home", component: AppComponent},
    {path: "grades", component: GradeviewComponent},
    // {path: "**", component: AppComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule {}
