import { Component } from '@angular/core';
import {carsPageUrl, clientsPageUrl, homePageUrl, loginPageUrl} from "../../models/links";

@Component({
  selector: 'app-navigation-bar',
  templateUrl: './navigation-bar.component.html',
  styleUrls: ['./navigation-bar.component.css']
})
export class NavigationBarComponent {

  protected readonly homePageUrl = homePageUrl;
  protected readonly clientsPageUrl = clientsPageUrl;
  protected readonly carsPageUrl = carsPageUrl;
  protected readonly loginPageUrl = loginPageUrl;
}
