import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateDoctorAccountComponent } from './update-doctor-account.component';

describe('UpdateDoctorAccountComponent', () => {
  let component: UpdateDoctorAccountComponent;
  let fixture: ComponentFixture<UpdateDoctorAccountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateDoctorAccountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateDoctorAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
