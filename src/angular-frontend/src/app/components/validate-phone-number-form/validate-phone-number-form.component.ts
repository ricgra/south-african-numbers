import { Component, OnInit } from '@angular/core';

import { PhoneNumberService } from '../../services/phone-number.service';

@Component({
  selector: 'app-validate-phone-number-form',
  templateUrl: './validate-phone-number-form.component.html',
  styleUrls: ['./validate-phone-number-form.component.css'],
})
export class ValidatePhoneNumberFormComponent implements OnInit {
  phoneNumber: string;

  validateMessage: string;
  isValid: boolean;

  constructor(private phoneNumberService: PhoneNumberService) {}

  ngOnInit(): void {}

  public validatePhoneNumberFromForm() {
    this.phoneNumberService.validatePhoneNumber(this.phoneNumber).subscribe(
      (data) => {
        this.isValid = data.valid;
        this.validateMessage = data.message;
      },
      (err) => {
        console.error(err);
      }
    );
  }
}
