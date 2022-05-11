import { Injectable } from '@angular/core';
import {MatSnackBar} from "@angular/material/snack-bar";
import {HttpClient} from "@angular/common/http";
import {Cliente} from "../../model/cliente";

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
    baseUrl = "http://localhost:8080/api/clientes/"


  constructor(private snackbar: MatSnackBar, private http: HttpClient) { }

  showMessage(msg: string): void{
      this.snackbar.open(msg,'X',{
          duration: 3000,
          horizontalPosition:"right",
          verticalPosition: "top"
      })
  }

    create(cliente: Cliente[]){
      return this.http.post(this.baseUrl, cliente)
  }
}
