import { inject, Injectable } from '@angular/core';
import { environment } from '../../../../envionments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Parking } from '../model/parking.model';

@Injectable({
  providedIn: 'root',
})
export class ParkingService {
  apiUrl: string = environment.apiUrl;

  http = inject(HttpClient);

  getParkingAll(): Observable<Parking[]> {
    return this.http.get<Parking[]>(this.apiUrl + '/parking');
  }
}
