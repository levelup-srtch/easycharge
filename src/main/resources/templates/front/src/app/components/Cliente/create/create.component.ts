import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Router} from "@angular/router";
import {ClienteService} from "../../../service/cliente.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  public form: FormGroup;
    public formBuilder: FormBuilder = new FormBuilder;


  constructor(private router: Router, private clienteService: ClienteService) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      id:[null],
      nome: ['',[Validators.required]],
      cpf: ['',[Validators.required]],
      telefone: ['',[Validators.required]],
      email: ['',[Validators.required]],
      profissao:['',[Validators.required]],
      renda: ['',[Validators.required]],
      StatusCliente:['',[Validators.required]],
      Endereco: ['',[Validators.required]]

    });
  }


  createCliente(): void{

    this.clienteService.create(this.form.value).subscribe((result: any) =>{
      this.clienteService.showMessage('Cliente Criado com Sucesso')
      this.router.navigate(['/clientes'])
    });

  }

  cancelar(): void{
    this.router.navigate(['/clientes'])
  }
}
