import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create',
  templateUrl: './divida-create.component.html',
  styleUrls: ['./divida-create.component.css']
})
export class DividaCreateComponent implements OnInit {
    hideRequiredControl: any;
  floatLabelControl: any;


  constructor() { }

  ngOnInit(): void {
  }

}
