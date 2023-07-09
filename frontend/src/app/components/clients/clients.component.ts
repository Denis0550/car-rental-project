import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatSort} from "@angular/material/sort";
import {MatPaginator} from "@angular/material/paginator";
import {ClientService} from "../../services/client/client.service";
import {Client} from "../../models/client";
import {FormControl, FormGroup, Validators} from "@angular/forms";



@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})


export class ClientsComponent implements OnInit {
  displayedColumns: Array<string> =
    ['id', 'name', 'surname', 'phone', 'email', 'address', 'hasDrivingLicense', 'registrationDateTime', 'dateOfBirth'];
  dataSource: MatTableDataSource<Client>;
  clients!: Array<Client>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  clientForm = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.minLength(2)]),
    surname: new FormControl('', [Validators.required, Validators.minLength(2)]),
    phone: new FormControl('', [Validators.required, Validators.minLength(7)]),
    email: new FormControl('', [Validators.required, Validators.email]),
    address: new FormControl(''),
    hasDrivingLicense: new FormControl(false, Validators.required),
    registrationDateTime: new FormControl(null),
    dateOfBirth: new FormControl('YYYY-MM-DD', [Validators.required, Validators.minLength(10)]),
  });



  constructor(private clientService: ClientService) {
    this.dataSource = new MatTableDataSource(this.clients);
    console.log('inside clients component constructor');
  }

  get name() {return this.clientForm.controls.name;}
  get surname() {return this.clientForm.controls.surname;}
  get phone() {return this.clientForm.controls.phone;}
  get email() {return this.clientForm.controls.email;}
  get address() {return this.clientForm.controls.address;}
  get drivingLicense() {return this.clientForm.controls.hasDrivingLicense;}
  get dateOfBirth() {return this.clientForm.controls.dateOfBirth;}


  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    this.clientService.getAllClients()
      .subscribe(clients => {
        this.clients = clients;
        this.dataSource.data = this.clients;
        console.log(`results: ${JSON.stringify(clients, null, 2)}`);
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
    console.log(`data to send: ${JSON.stringify(this.clientForm.value, null, 2)}`);
  }



}

