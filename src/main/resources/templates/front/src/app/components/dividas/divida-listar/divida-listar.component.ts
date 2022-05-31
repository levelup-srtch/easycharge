import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-divida-listar',
  templateUrl: './divida-listar.component.html',
  styleUrls: ['./divida-listar.component.css']
})
export class DividaListarComponent implements OnInit {
  dividas: any;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

    novaDivida() {
    this.router.navigate(['/dividas/create'])
    }

  announceSortChange($event: any) {
    
  }
}
