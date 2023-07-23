import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {Car} from "../../models/car";
import {CarService} from "../../services/car/car.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})



export class CarsComponent implements OnInit {

  cars!: Array<Car>;

  constructor(private carService: CarService) {

    console.log('inside cars component constructor');
  }



  ngOnInit(): void {
    this.fetchCars();
  }

  private fetchCars() {
    this.carService.allCars().subscribe(cars => {
      this.cars = cars;
      console.log(`results: ${JSON.stringify(cars, null, 2)}`);
    });

  }

}
