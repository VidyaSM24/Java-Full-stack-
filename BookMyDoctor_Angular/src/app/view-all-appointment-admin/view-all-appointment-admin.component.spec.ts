import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllAppointmentAdminComponent } from './view-all-appointment-admin.component';

describe('ViewAllAppointmentAdminComponent', () => {
  let component: ViewAllAppointmentAdminComponent;
  let fixture: ComponentFixture<ViewAllAppointmentAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAllAppointmentAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAllAppointmentAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
