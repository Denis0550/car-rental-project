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

  displayedColumns: Array<string> =
    ['id', 'brand', 'model', 'productionYear', 'color', 'available'];
  dataSource: MatTableDataSource<Car>;
  cars!: Array<Car>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;


  carForm = new FormGroup({
    brand: new FormControl('',),
    model: new FormControl('',),
    productionYear: new FormControl(''),
    color: new FormControl(''),
    available: new FormControl(''),
    // priceList: new FormControl(''),
  });


  constructor(private carService: CarService) {
    this.dataSource = new MatTableDataSource(this.cars)
    console.log('inside cars component constructor');
  }

  get brand() {return this.carForm.controls.brand;}
  get model() {return this.carForm.controls.model;}
  get productionYear() {return this.carForm.controls.productionYear;}
  get color() {return this.carForm.controls.color;}
  get available() {return this.carForm.controls.available;}

  //priceList


  ngOnInit(): void {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    this.fetchCars();
  }

  private fetchCars() {
    this.carService.getAllCars().subscribe(cars => {
      this.cars = cars;
      this.dataSource.data = this.cars;
      console.log(`results: ${JSON.stringify(cars, null, 2)}`);
    });

  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  onSubmit() {
    console.log(`data to send: ${JSON.stringify(this.carForm.value, null, 2)}`);

    // this.carService.createCar(this.carForm.value as Car | JSON)
    // .subscribe(value => {
    //   this.carForm.reset();
    //   this.fetchCars();
    // });
  }


}
