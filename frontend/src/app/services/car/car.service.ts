import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {allCarsUrl, createCarUrl} from "../../models/links";
import {Car} from "../../models/car";

@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private http: HttpClient) { }


  allCars(): Observable<Array<Car>> {
    return this.http.get<any>(allCarsUrl)
    .pipe(
      map(value => {
        return value.content;
      })
    )
  }

  createCar(car: Car): Observable<Car> {
    return this.http.post<Car>(createCarUrl, car);
  }





}

