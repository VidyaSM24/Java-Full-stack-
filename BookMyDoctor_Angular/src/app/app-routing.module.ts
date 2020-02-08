import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { AddDoctorComponent } from './add-doctor/add-doctor.component';
import { AddAppointmentComponent } from './add-appointment/add-appointment.component';
import { AddRatingComponent } from './add-rating/add-rating.component';
import { ViewAppointmentsComponent } from './view-appointments/view-appointments.component';
import { ViewPatientsComponent } from './view-patients/view-patients.component';
import { ViewDoctorsComponent } from './view-doctors/view-doctors.component';
import { ViewRatingsComponent } from './view-ratings/view-ratings.component';
import { EditRatingsComponent } from './edit-ratings/edit-ratings.component';
import { EditAppointmentsComponent } from './edit-appointments/edit-appointments.component';
import { EditAvailabilityComponent } from './edit-availability/edit-availability.component';
import { EditDoctorComponent } from './edit-doctor/edit-doctor.component';
import { EditPatientComponent } from './edit-patient/edit-patient.component';
import { RegisterPatientComponent } from './register-patient/register-patient.component';
import { RegisterDoctorComponent } from './register-doctor/register-doctor.component';
import { AdminNavComponent } from './admin-nav/admin-nav.component';
import { DoctorNavComponent } from './doctor-nav/doctor-nav.component';
import { PatientNavComponent } from './patient-nav/patient-nav.component';
import { DoctorsInfoComponent } from './doctors-info/doctors-info.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { TestsComponent } from './tests/tests.component';
import { TermsComponent } from './terms/terms.component';
import { DoctorsPatientComponent } from './doctors-patient/doctors-patient.component';
import { PatientInnerNavComponent } from './patient-inner-nav/patient-inner-nav.component';
import { DoctorAvailabilityComponent } from './doctor-availability/doctor-availability.component';
import { AddAvailabalityComponent } from './add-availabality/add-availabality.component';
import { ViewAvailabilityComponent } from './view-availability/view-availability.component';


import { ViewAllUsersComponent } from './view-all-users/view-all-users.component';
import { GetAllHistoryComponent } from './get-all-history/get-all-history.component';
import { UpdateDoctorAccountComponent } from './update-doctor-account/update-doctor-account.component';
import { UpdatePatientAccountComponent } from './update-patient-account/update-patient-account.component';
import { UpdateLoginComponent } from './update-login/update-login.component';
import { ViewAppointmentsPatientComponent } from './view-appointments-patient/view-appointments-patient.component';
import { ViewAllAppointmentAdminComponent } from './view-all-appointment-admin/view-all-appointment-admin.component';
import { SearchUserComponent } from './search-user/search-user.component';
import { SearchDoctorComponent } from './search-doctor/search-doctor.component';
import { SearchAdminComponent } from './search-admin/search-admin.component';
import { UpdateAppointmentsAdminComponent } from './update-appointments-admin/update-appointments-admin.component';
import { ContactusComponent } from './contactus/contactus.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginUserComponent},
 {path:'contact-us',component:ContactusComponent},
  {path: 'tests',component:TestsComponent},
  {path:'terms',component:TermsComponent},
{path:'register-patient',component:RegisterPatientComponent},
{path:'register-doctor',component:RegisterDoctorComponent},
{path:'update-password',component:UpdateLoginComponent},
{path:'view-profile',component:SearchUserComponent},

 
 


{path:'admin',component:AdminNavComponent, children:[
  {path:'add-patient', component: AddPatientComponent},
  {path:'add-doctor', component: AddDoctorComponent},
  {path: 'all-appointments-admin',component: ViewAllAppointmentAdminComponent},
  {path: 'all-patients', component: ViewPatientsComponent},
  {path: 'all-doctors', component: ViewDoctorsComponent},
  {path: 'all-history', component: GetAllHistoryComponent},
  {path: 'all-ratings',component: ViewRatingsComponent},
  {path:'modify-patient/:patientId',component:EditPatientComponent},
  {path:'modify-doctor/:doctorId',component:EditDoctorComponent},
  // {path:'modify-appointment/:appointmentId',component: EditAppointmentsComponent},
  {path:'all-users',component:ViewAllUsersComponent},
  {path:'update-password',component:UpdateLoginComponent},
  {path:'view-admin-profile',component:SearchAdminComponent},
  {path:'update-appointment-admin/:appointmentId',component:UpdateAppointmentsAdminComponent},
  

  
  
]},
{path:'doctor',component:DoctorNavComponent,  children: [
  {path: 'doctor-availability', component: DoctorAvailabilityComponent},
  {path: 'all-appointments',component: ViewAppointmentsComponent},
  {path:'modify-appointment/:appointmentId',component: EditAppointmentsComponent},
  {path:'modify-availabality/:availabalityId',component: EditAvailabilityComponent},
  {path:'update-doctor-profile',component:UpdateDoctorAccountComponent},
  {path:'update-password',component:UpdateLoginComponent},
  {path:'view-doctor-profile',component:SearchDoctorComponent},
  {path:'add-availability',component:AddAvailabalityComponent},
  {path:'view-availabilities',component:ViewAvailabilityComponent},
  {path:'modify-availability/:availabilityId',component:EditAvailabilityComponent}

 

]},
{path:'patient',component:PatientNavComponent, children: [
  {path: 'add-appointment', component: AddAppointmentComponent},
  {path: 'all-doctors', component: ViewDoctorsComponent},
  {path: 'doctors-patient',component:DoctorsPatientComponent},
  {path: 'add-rating', component: AddRatingComponent},
  {path: 'all-ratings',component: ViewRatingsComponent},
  {path: 'patient-inner',component:PatientInnerNavComponent},
  {path:'modify-rating/:ratingId', component:EditRatingsComponent},
   
  
  
]},

{path: 'patient-inner',component:PatientInnerNavComponent, children:[
  {path: 'all-ratings',component: ViewRatingsComponent},
  {path: 'doctors-patient',component:DoctorsPatientComponent},
  {path:'all-availabilities',component:ViewAvailabilityComponent},
  {path:'modify-patient/:patientId',component:EditPatientComponent},
  {path:'update-patient-profile',component:UpdatePatientAccountComponent},

  {path:'update-password',component:UpdateLoginComponent},
  {path:'all-appointment-patient',component:ViewAppointmentsPatientComponent},
  {path:'view-profile',component:SearchUserComponent},
 
]},


{path:'doctors-information',component:DoctorsInfoComponent},
{path: 'add-appointment', component: AddAppointmentComponent},
{path:'add-availability',component:AddAvailabalityComponent},
{path: 'add-rating', component: AddRatingComponent},
{path:'modify-appointment/:appointmentId',component: EditAppointmentsComponent},
{path:'update-appointment-admin/:appointmentId',component:UpdateAppointmentsAdminComponent},
{path:'modify-availability/:availabilityId',component:EditAvailabilityComponent},
{path:'**',component:PageNotFoundComponent}





];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
