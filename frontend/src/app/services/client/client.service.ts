import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {allClients} from "../../models/links";
import {Client} from "../../models/client";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(
              private http: HttpClient ) { }


  getAllClients(): Observable<Array<Client>> {
    console.log("calling ???")

    return this.http.get<Array<Client>>(allClients);

  }

}
