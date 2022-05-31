import {Injectable} from '@angular/core';
import {MatSnackBar} from "@angular/material/snack-bar";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Cliente} from "../model/cliente";

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  baseUrl = "http://localhost:8080/api/clientes/"

  constructor(private snackbar: MatSnackBar, private http: HttpClient) { }

  showMessage(msg: string): void{
    this.snackbar.open(msg, 'X',{
      duration: 3000,
      horizontalPosition:"right",
      verticalPosition: "top"
    })
  }

  public findAll(): Observable<Cliente[]>{
    return this.http.get<Cliente[]>(this.baseUrl)
  }
  public findById(id: any): Observable<Cliente>{
    const url = this.baseUrl + `/${id}`;
    return this.http.get<Cliente>(url);
  }
  public create(cliente: Cliente): Observable<Cliente>{
    return this.http.post<Cliente>(this.baseUrl,cliente);
  }
  public update(cliente: Cliente): Observable<Cliente> {
    const url = this.baseUrl + `/${cliente.id}`;
    return this.http.put<Cliente>(url, cliente);
  }
  public indativarCliente(id:any, cliente: Cliente): Observable<Cliente>{
    const url = this.baseUrl + `/desativa/${id}`;
    return this.http.put<Cliente>(url,cliente);
  }
}
