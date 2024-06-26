import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlayerlistComponent } from 'src/app/Player/playerlist/playerlist.component';
import { PlayerDetailsComponent } from 'src/app/Player/player-details/player-details.component';
import { AppComponent } from './app.component';
import { LoginComponent } from './authentication/login/login.component';
import { RegisterComponent } from './authentication/register/register.component';
import { NavbarComponent } from './Player/navbar/navbar.component';
import { AuthGuard } from './auth.guard';
import { DashboardComponent } from './Player/dashboard/dashboard.component';
import { UpdateComponent } from './authentication/update/update.component';
import { SearchComponent } from './Player/search/search.component';
import { FavouritesComponent } from './Player/favourites/favourites.component';
import { RecommendComponent } from './Player/recommend/recommend.component';
import { HomeComponent } from './Player/home/home.component';


const routes: Routes = [
  {
    path:'',
    component:HomeComponent
  },
  {
    path:'search',
    component:SearchComponent,
    canActivate:[AuthGuard]
  },
  {
    path:'login',
    component:LoginComponent
  },
  {
    path:'register',
    component:RegisterComponent
  },
  {
    path:'Playerlist',
    component:PlayerlistComponent,
    canActivate:[AuthGuard]
  },
  {
    path:'PlayerDetails/:id',
    component: PlayerDetailsComponent,
    canActivate:[AuthGuard]
  },
  {
    path:'UserProfile',
    component:DashboardComponent,
    canActivate:[AuthGuard]
  },
  {
    path:'update',
    component:UpdateComponent,
    canActivate:[AuthGuard]
  },
  {
    path:'favourites',
    component:FavouritesComponent,
    canActivate:[AuthGuard]
  },
  {
    path:'recommend',
    component:RecommendComponent,
    canActivate:[AuthGuard]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents=[PlayerDetailsComponent,PlayerDetailsComponent]
