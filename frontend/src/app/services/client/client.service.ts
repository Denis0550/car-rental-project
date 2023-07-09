import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {allClientsUrl, createClientUrl} from "../../models/links";
import {Client} from "../../models/client";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(
              private http: HttpClient ) { }


  getAllClients(): Observable<Array<Client>> {

    return this.http.get<Array<Client>>(allClientsUrl);

  }

  createClient(client: Client): Observable<Client> {
    return this.http.post<Client>(createClientUrl, client);
  }








}
