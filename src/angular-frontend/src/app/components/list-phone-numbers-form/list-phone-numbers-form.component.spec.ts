import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListPhoneNumbersFormComponent } from './list-phone-numbers-form.component';

describe('ListPhoneNumbersFormComponent', () => {
  let component: ListPhoneNumbersFormComponent;
  let fixture: ComponentFixture<ListPhoneNumbersFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListPhoneNumbersFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListPhoneNumbersFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
