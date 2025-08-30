import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GradeviewComponent } from './gradeview.component';

describe('GradeviewComponent', () => {
  let component: GradeviewComponent;
  let fixture: ComponentFixture<GradeviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GradeviewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GradeviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
