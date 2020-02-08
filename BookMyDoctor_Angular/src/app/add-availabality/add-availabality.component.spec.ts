import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAvailabalityComponent } from './add-availabality.component';

describe('AddAvailabalityComponent', () => {
  let component: AddAvailabalityComponent;
  let fixture: ComponentFixture<AddAvailabalityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddAvailabalityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddAvailabalityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
