import { Component } from '@angular/core';

import { PhoneNumberService } from './services/phone-number.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'South African Phone Numbers';

  constructor(private phoneNumberService: PhoneNumberService) {}

  public exportAsCSV() {
    this.phoneNumberService.downloadPhoneNumbersAsCSV();
  }
}
