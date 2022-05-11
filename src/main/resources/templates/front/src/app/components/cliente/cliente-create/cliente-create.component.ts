import {Component, OnInit} from '@angular/core';
import {ClienteService} from "../cliente.service";
import {Router} from "@angular/router";
import {Cliente} from "../../../model/cliente";


@Component({
  selector: 'app-cliente-create',
  templateUrl: './cliente-create.component.html',
  styleUrls: ['./cliente-create.component.css']
})
export class ClienteCreateComponent implements OnInit {

  cliente : Cliente [] = []


  constructor(private clienteService: ClienteService, private router: Router) { }

  ngOnInit(): void {

  }
  createCliente(): void{
    this.clienteService.create(this.cliente).subscribe(()=>{
      this.clienteService.showMessage('Cliente Criado com Sucesso')
      this.router.navigate(['/clientes'])
    })

  }
  cancelar(): void{
    this.router.navigate(['/clientes'])
  }

}
