import { Pipe, PipeTransform } from '@angular/core';
import { Doctor } from './doctor';

@Pipe({
  name: 'filterDoctor'
})
export class FilterDoctorPipe implements PipeTransform {

  transform(doctors: Doctor[], search: string) {
    if (search && doctors.length > 0) {
      debugger;
      let filteredDoctors = doctors.filter(doctor => {
        if (doctor && search && doctor.specialization !== null && doctor.specialization.toLowerCase().includes(search.toLowerCase())) {
          return true;
        } else {
          return false;
        }
      });
      return filteredDoctors;
    } else {
      return doctors;
    }
  }

}
