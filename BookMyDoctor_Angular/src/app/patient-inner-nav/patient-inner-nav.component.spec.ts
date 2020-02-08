import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientInnerNavComponent } from './patient-inner-nav.component';

describe('PatientInnerNavComponent', () => {
  let component: PatientInnerNavComponent;
  let fixture: ComponentFixture<PatientInnerNavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PatientInnerNavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientInnerNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
