import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterPatient'
})
export class FilterPatientPipe implements PipeTransform {

  transform(patients: Patient[], search: string): Patient[] {
    if (search === undefined) {
      return patients;
    }
    return patients.filter((patient, index) => {
      return patient.patientFirstName.toLowerCase().includes(search.toLowerCase());
    });
  }

}
