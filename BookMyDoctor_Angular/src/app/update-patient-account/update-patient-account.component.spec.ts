import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatePatientAccountComponent } from './update-patient-account.component';

describe('UpdatePatientAccountComponent', () => {
  let component: UpdatePatientAccountComponent;
  let fixture: ComponentFixture<UpdatePatientAccountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdatePatientAccountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatePatientAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
