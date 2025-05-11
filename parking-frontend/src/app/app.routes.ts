import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    title: 'Acceuil',
    loadComponent: () => import('./ui/parking-list/parking-list.component'),
  },

  {
    path: 'parking',
    title: 'Parking',
    loadComponent: () => import('./ui/parking-list/parking-list.component'),
  },
];
