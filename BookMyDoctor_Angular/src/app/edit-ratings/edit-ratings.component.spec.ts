import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditRatingsComponent } from './edit-ratings.component';

describe('EditRatingsComponent', () => {
  let component: EditRatingsComponent;
  let fixture: ComponentFixture<EditRatingsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditRatingsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditRatingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
