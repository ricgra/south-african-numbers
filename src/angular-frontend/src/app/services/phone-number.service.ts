import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';

import { saveAs } from 'file-saver';
import { PhoneNumberOutput } from '../models/phonenumberoutput';
import { ValidateOutput } from '../models/validateoutput';

@Injectable({
  providedIn: 'root',
})
export class PhoneNumberService {
  private backendUrl: string;

  constructor(private httpClient: HttpClient) {
    this.backendUrl = 'http://localhost:8080/rest/phone-number';
  }

  public uploadCSVRequest(file: File): Observable<HttpEvent<any>> {
    let formData: FormData = new FormData();
    formData.append('file', file, file.name);

    const req = new HttpRequest('POST', `${this.backendUrl}/csv`, formData, {
      responseType: 'json',
    });

    return this.httpClient.request(req);
  }

  public getPhoneNumbers(): Observable<PhoneNumberOutput> {
    return this.httpClient.get<PhoneNumberOutput>(`${this.backendUrl}`, {});
  }

  public downloadPhoneNumbersAsCSV() {
    this.downloadCsv().subscribe(
      (data) => {
        saveAs(data, 'export.csv');
      },
      (err) => {
        console.error(err);
      }
    );
  }

  public validatePhoneNumber(phoneNumber: string): Observable<ValidateOutput> {
    return this.httpClient.get<ValidateOutput>(
      `${this.backendUrl}/${phoneNumber}/validate`,
      {}
    );
  }

  private downloadCsv(): Observable<any> {
    return this.httpClient.get(`${this.backendUrl}/csv`, {
      responseType: 'blob',
    });
  }
}
