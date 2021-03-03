import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValidatePhoneNumberFormComponent } from './validate-phone-number-form.component';

describe('ValidatePhoneNumberFormComponent', () => {
  let component: ValidatePhoneNumberFormComponent;
  let fixture: ComponentFixture<ValidatePhoneNumberFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ValidatePhoneNumberFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ValidatePhoneNumberFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
