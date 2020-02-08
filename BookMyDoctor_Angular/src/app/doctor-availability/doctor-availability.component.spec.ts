import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorAvailabilityComponent } from './doctor-availability.component';

describe('DoctorAvailabilityComponent', () => {
  let component: DoctorAvailabilityComponent;
  let fixture: ComponentFixture<DoctorAvailabilityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DoctorAvailabilityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorAvailabilityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
