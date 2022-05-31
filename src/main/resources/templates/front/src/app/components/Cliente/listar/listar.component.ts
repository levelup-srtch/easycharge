import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-divida-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  novoCliente(): void{
    this.router.navigate(['/clientes/create'])
  }
}
