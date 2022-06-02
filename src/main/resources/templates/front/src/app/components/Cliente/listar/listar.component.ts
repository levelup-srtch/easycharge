import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {Cliente} from 'src/app/model/cliente';
import {ClienteService} from 'src/app/service/cliente.service';

@Component({
  selector: 'app-divida-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  cliente: Cliente[] = []
  displayedColumns: string[] = [ 'nome', 'cpf', 'telefone','email','profissao','renda',
    'status','rua','numero','complemento','bairro','cidade','estado'];
  dataSource = this.cliente;

  constructor(private router: Router,
              private servico :ClienteService) { }

  ngOnInit(): void {
    this.buscarTodos()

  }

  buscarTodos(): void{
    this.servico.findAll().subscribe((res)=>{

      this.cliente = res
      console.log(res)
    })
  }

  novoCliente(): void{
    this.router.navigate(['/clientes/create'])
  }
}
