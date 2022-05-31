import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./views/home/home.component";
import {ListarComponent} from "./components/Cliente/listar/listar.component";
import {DividaListarComponent} from "./components/dividas/divida-listar/divida-listar.component";
import {CreateComponent} from "./components/Cliente/create/create.component";
import {DividaCreateComponent} from "./components/dividas/create/divida-create.component";
import {CobrancasListarComponent} from "./components/cobrancas/cobrancas-listar/cobrancas-listar.component";


const routes: Routes = [{
  path:"",
  component:HomeComponent
},
  {
    path:"clientes",
    component:ListarComponent
  },
  {
    path:"clientes/create",
    component:CreateComponent
  },
  {
    path:"dividas",
    component:DividaListarComponent
  },
  {
    path:"dividas/create",
    component: DividaCreateComponent
  },
  {
    path:"cobrancas",
    component:CobrancasListarComponent
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
