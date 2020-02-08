import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { AddDoctorComponent } from './add-doctor/add-doctor.component';
import { AddAppointmentComponent } from './add-appointment/add-appointment.component';
import { AddRatingComponent } from './add-rating/add-rating.component';
import { ViewDoctorsComponent } from './view-doctors/view-doctors.component';
import { ViewPatientsComponent } from './view-patients/view-patients.component';
import { ViewAppointmentsComponent } from './view-appointments/view-appointments.component';
import { AddAvailabalityComponent } from './add-availabality/add-availabality.component';
import { FilterDoctorPipe } from './filter-doctor.pipe';
import { FilterPatientPipe } from './filter-patient.pipe';
import { ViewRatingsComponent } from './view-ratings/view-ratings.component';
import { EditPatientComponent } from './edit-patient/edit-patient.component';
import { EditRatingsComponent } from './edit-ratings/edit-ratings.component';
import { EditAppointmentsComponent } from './edit-appointments/edit-appointments.component';
import { EditAvailabilityComponent } from './edit-availability/edit-availability.component';
import { EditDoctorComponent } from './edit-doctor/edit-doctor.component';
import { RegisterPatientComponent } from './register-patient/register-patient.component';
import { RegisterDoctorComponent } from './register-doctor/register-doctor.component';
import { ViewAvailabilityComponent } from './view-availability/view-availability.component';
import { AdminNavComponent } from './admin-nav/admin-nav.component';
import { DoctorNavComponent } from './doctor-nav/doctor-nav.component';
import { PatientNavComponent } from './patient-nav/patient-nav.component';
import { DoctorsInfoComponent } from './doctors-info/doctors-info.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { TestsComponent } from './tests/tests.component';
import { TermsComponent } from './terms/terms.component';
import { DoctorsPatientComponent } from './doctors-patient/doctors-patient.component';
import { FilterSpecilistPipe } from './filter-specilist.pipe';
import { PatientInnerNavComponent } from './patient-inner-nav/patient-inner-nav.component';
import { DoctorAvailabilityComponent } from './doctor-availability/doctor-availability.component';
import { UpdatePatientAccountComponent } from './update-patient-account/update-patient-account.component';
import { UpdateDoctorAccountComponent } from './update-doctor-account/update-doctor-account.component';
 
import { ViewAllUsersComponent } from './view-all-users/view-all-users.component';
import { GetAllHistoryComponent } from './get-all-history/get-all-history.component';
import { UpdateLoginComponent } from './update-login/update-login.component';
import { ViewAllMailsComponent } from './view-all-mails/view-all-mails.component';
import { ViewAppointmentsPatientComponent } from './view-appointments-patient/view-appointments-patient.component';
import { ViewAllAppointmentAdminComponent } from './view-all-appointment-admin/view-all-appointment-admin.component';
import { SearchUserComponent } from './search-user/search-user.component';
import { SearchAdminComponent } from './search-admin/search-admin.component';
import { SearchDoctorComponent } from './search-doctor/search-doctor.component';
import { UpdateAppointmentsAdminComponent } from './update-appointments-admin/update-appointments-admin.component';
import { ContactusComponent } from './contactus/contactus.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';






@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    AddPatientComponent,
    AddDoctorComponent,
    AddAppointmentComponent,
    AddRatingComponent,
    ViewDoctorsComponent,
    ViewPatientsComponent,
    ViewAppointmentsComponent,
    AddAvailabalityComponent,
    FilterDoctorPipe,
    FilterPatientPipe,
    ViewRatingsComponent,
    EditPatientComponent,
    EditRatingsComponent,
    EditAppointmentsComponent,
    EditAvailabilityComponent,
    EditDoctorComponent,
    RegisterPatientComponent,
    RegisterDoctorComponent,
    ViewAvailabilityComponent,
    AdminNavComponent,
    DoctorNavComponent,
    PatientNavComponent,
    DoctorsInfoComponent,
    LoginUserComponent,
    TestsComponent,
    TermsComponent,
    DoctorsPatientComponent,
    FilterSpecilistPipe,
    PatientInnerNavComponent,
    DoctorAvailabilityComponent,
    UpdatePatientAccountComponent,
    UpdateDoctorAccountComponent,
    ViewAllUsersComponent,
    GetAllHistoryComponent,
    UpdateLoginComponent,
    ViewAllMailsComponent,
    ViewAppointmentsPatientComponent,
    ViewAllAppointmentAdminComponent,
    SearchUserComponent,
    SearchAdminComponent,
    SearchDoctorComponent,
    UpdateAppointmentsAdminComponent,
    ContactusComponent,
    PageNotFoundComponent
    
  
   
    
    

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
