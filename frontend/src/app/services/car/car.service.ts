import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {allCarsUrl, createCarUrl} from "../../models/links";
import {Car} from "../../models/car";

@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private http: HttpClient) { }


  getAllCars(): Observable<Array<Car>> {

    return this.http.get<Array<Car>>(allCarsUrl);

  }

  createCar(car: Car): Observable<Car> {
    return this.http.post<Car>(createCarUrl, car);
  }





}

