import { Component } from '@angular/core';
import {homePageUrl} from "../../models/links";

@Component({
  selector: 'app-not-found-page',
  templateUrl: './not-found-page.component.html',
  styleUrls: ['./not-found-page.component.css']
})
export class NotFoundPageComponent {

  protected readonly homePageUrl = homePageUrl;
}
