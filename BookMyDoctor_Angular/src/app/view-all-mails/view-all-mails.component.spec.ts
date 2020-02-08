import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllMailsComponent } from './view-all-mails.component';

describe('ViewAllMailsComponent', () => {
  let component: ViewAllMailsComponent;
  let fixture: ComponentFixture<ViewAllMailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAllMailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAllMailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
