import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PhoneNumberOutput } from 'src/app/models/phonenumberoutput';
import { PhoneNumberService } from 'src/app/services/phone-number.service';

@Component({
  selector: 'app-list-phone-numbers-form',
  templateUrl: './list-phone-numbers-form.component.html',
  styleUrls: ['./list-phone-numbers-form.component.css'],
})
export class ListPhoneNumbersFormComponent implements OnInit {
  phoneNumbersOutput: PhoneNumberOutput;

  constructor(private phoneNumberService: PhoneNumberService) {}

  ngOnInit(): void {
    this.phoneNumberService.getPhoneNumbers().subscribe(
      (data) => {
        this.phoneNumbersOutput = data;
      },
      (err) => {
        console.error(err);
      }
    );
  }
}
