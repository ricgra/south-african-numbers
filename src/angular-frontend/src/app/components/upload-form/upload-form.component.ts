import { Component, OnInit } from '@angular/core';
import { PhoneNumberService } from '../../services/phone-number.service';

@Component({
  selector: 'app-upload-form',
  templateUrl: './upload-form.component.html',
  styleUrls: ['./upload-form.component.css'],
})
export class UploadFormComponent implements OnInit {
  declare fileToUpload: File;

  uploadMessage: string = '';

  constructor(private phoneNumberService: PhoneNumberService) {}

  ngOnInit(): void {}

  handleFileSelection(event: any) {
    this.fileToUpload = event.target.files.item(0);
  }

  uploadCSV() {
    this.phoneNumberService.uploadCSVRequest(this.fileToUpload).subscribe(
      (data) => {
        console.log(data);

        this.uploadMessage = 'ok';
      },
      (err) => {
        console.error(err);

        this.uploadMessage = 'Error: ' + err.message;
      }
    );
  }
}
