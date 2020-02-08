import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllHistoryComponent } from './get-all-history.component';

describe('GetAllHistoryComponent', () => {
  let component: GetAllHistoryComponent;
  let fixture: ComponentFixture<GetAllHistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetAllHistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAllHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
