import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAppointmentsPatientComponent } from './view-appointments-patient.component';

describe('ViewAppointmentsPatientComponent', () => {
  let component: ViewAppointmentsPatientComponent;
  let fixture: ComponentFixture<ViewAppointmentsPatientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAppointmentsPatientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAppointmentsPatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
