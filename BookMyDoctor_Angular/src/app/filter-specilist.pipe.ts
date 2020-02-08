import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterSpecilist'
})
export class FilterSpecilistPipe implements PipeTransform {

  transform(doctors: Doctor[], search: string): Doctor[] {
    if (search === undefined) {
      return doctors;
    }
    return doctors.filter((doctor, index) => {
      return doctor.specialization.toLowerCase().includes(search.toLowerCase());
    }
    );
  }

}
