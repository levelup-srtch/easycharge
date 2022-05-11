import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./views/home/home.component";
import {ClienteCrudComponent} from "./views/cliente-crud/cliente-crud.component";
import {ClienteCreateComponent} from "./components/cliente/cliente-create/cliente-create.component";


const routes: Routes = [{
    path:"",
    component: HomeComponent
  },
  {
    path:"clientes",
    component:ClienteCrudComponent
  },
    {
        path:"clientes/create",
        component:ClienteCreateComponent
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
