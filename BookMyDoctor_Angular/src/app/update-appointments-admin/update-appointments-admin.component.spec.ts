import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateAppointmentsAdminComponent } from './update-appointments-admin.component';

describe('UpdateAppointmentsAdminComponent', () => {
  let component: UpdateAppointmentsAdminComponent;
  let fixture: ComponentFixture<UpdateAppointmentsAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateAppointmentsAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateAppointmentsAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
