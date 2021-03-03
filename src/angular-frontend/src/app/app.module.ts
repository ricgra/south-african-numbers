import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UploadFormComponent } from './components/upload-form/upload-form.component';
import { ListPhoneNumbersFormComponent } from './components/list-phone-numbers-form/list-phone-numbers-form.component';
import { ValidatePhoneNumberFormComponent } from './components/validate-phone-number-form/validate-phone-number-form.component';

@NgModule({
  declarations: [
    AppComponent,
    UploadFormComponent,
    ListPhoneNumbersFormComponent,
    ValidatePhoneNumberFormComponent,
  ],
  imports: [
    BrowserModule,
    CommonModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
