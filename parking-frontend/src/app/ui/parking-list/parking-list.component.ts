import { Component, inject, OnDestroy, OnInit } from '@angular/core';
import { ParkingService } from '../../core/services/parking.service';
import { Parking } from '../../core/model/parking.model';

@Component({
  selector: 'app-parking-list',
  imports: [],
  templateUrl: './parking-list.component.html',
  styleUrl: './parking-list.component.css',
})
export default class ParkingListComponent implements OnInit, OnDestroy {
  ngOnDestroy(): void {
    throw new Error('Method not implemented.');
  }
  ngOnInit(): void {
    this.loadParkings();
  }
  parkings: Parking[] = [];

  private parkingService = inject(ParkingService);

  loadParkings(): void {
    if (!this.parkings) {
      console.log('Pas de données');
    }
    this.parkingService.getParkingAll().subscribe((data) => {
      this.parkings = data;
      console.log(data);
    });
  }
}
