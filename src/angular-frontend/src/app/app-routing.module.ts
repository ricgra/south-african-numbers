import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListPhoneNumbersFormComponent } from './components/list-phone-numbers-form/list-phone-numbers-form.component';
import { UploadFormComponent } from './components/upload-form/upload-form.component';
import { ValidatePhoneNumberFormComponent } from './components/validate-phone-number-form/validate-phone-number-form.component';

const routes: Routes = [
  { path: 'upload-form', component: UploadFormComponent },
  { path: 'list-phone-numbers-form', component: ListPhoneNumbersFormComponent },
  {
    path: 'validate-phone-number-form',
    component: ValidatePhoneNumberFormComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
