import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HeaderComponent} from './components/templete/header/header.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {FooterComponent} from './components/templete/footer/footer.component';
import {NavComponent} from './components/templete/nav/nav.component';
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatListModule} from "@angular/material/list";
import {HomeComponent} from "./views/home/home.component";
import {MatCardModule} from "@angular/material/card";
import {ListarComponent} from './components/Cliente/listar/listar.component';
import {MatTableModule} from "@angular/material/table";
import {MatButtonModule} from "@angular/material/button";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {HttpClientModule} from "@angular/common/http";
import {CreateComponent} from "./components/Cliente/create/create.component";
import {ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {DividaListarComponent} from "./components/dividas/divida-listar/divida-listar.component";
import {CobrancasListarComponent} from './components/cobrancas/cobrancas-listar/cobrancas-listar.component';
import {DividaCreateComponent} from "./components/dividas/create/divida-create.component";
import {MatDatepickerModule} from "@angular/material/datepicker";


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavComponent,
    FooterComponent,
    HomeComponent,
    ListarComponent,
    CreateComponent,
    DividaListarComponent,
    CobrancasListarComponent,
    DividaCreateComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatCardModule,
    MatTableModule,
    MatButtonModule,
    MatSnackBarModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
   
   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
