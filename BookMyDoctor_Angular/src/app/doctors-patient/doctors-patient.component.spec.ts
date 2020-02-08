import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorsPatientComponent } from './doctors-patient.component';

describe('DoctorsPatientComponent', () => {
  let component: DoctorsPatientComponent;
  let fixture: ComponentFixture<DoctorsPatientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DoctorsPatientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorsPatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
