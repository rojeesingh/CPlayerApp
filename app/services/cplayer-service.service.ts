import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs';
import { CricPlayer } from '../cric-player';
export const USER_NAME = "username";


@Injectable({
  providedIn: 'root'
})
export class CplayerServiceService {

  cplayerApi: String;
  apiKey: String;
  playerInfo:string;
  favouritEndPoint: string;
  searchInfo:string; 
  recommendEndPoint: string;
  username: string="";


  constructor(private http: HttpClient) {
    this.cplayerApi = 'https://api.cricapi.com/v1/players?';
  // this.apiKey = 'apikey=bb1861a3-6be3-4894-b8ac-b83b9183899c';
  //this.apiKey = 'apikey=fb20bf3d-215a-4d5e-88e0-ddece631cea3';
  //  this.apiKey = 'apikey=937a2e45-b8d1-41f9-acbb-b288f52eae57';
  this.apiKey ='ef691f5a-9853-48f4-88b8-1a32f6304c9b';
 //this.apiKey = 'apikey=290b21e9-ab64-45cd-a7dd-a33e9dde791c';
    //this.apiKey = 'apikey=0e192204-ee03-452f-bcd8-95b9a0168902';
    this.playerInfo='https://api.cricapi.com/v1/players_info?';
     this.searchInfo = "https://api.cricapi.com/v1/players?apikey=6e224315-4750-4d8b-9ba2-7f00bd93d53a&offset=0&search=";
    this.favouritEndPoint= 'http://localhost:8083/api/v1/favoriteservice';
    this.recommendEndPoint= 'http://localhost:8082/api/v1/player/recommend/10';
}
getAllPlayerList(pid:String): Observable<any> {
    
 
  this.apiKey = 'apikey=ef691f5a-9853-48f4-88b8-1a32f6304c9b&id='+pid;
  const url = `${this.playerInfo}${this.apiKey}`;
  return this.http.get(url);
}

getPlayerDetails(pid:String):Observable<any> 
{
 
  this.apiKey = 'apikey=ef691f5a-9853-48f4-88b8-1a32f6304c9b&id='+pid;
  const url = `${this.playerInfo}${this.apiKey}`;
  return this.http.get(url);
}
addPlayerToFavoriteList(cPlayer:CricPlayer) 
{
  console.log("caled");
  this.username =  sessionStorage.getItem(USER_NAME) || '{}';
 const url = this.favouritEndPoint + "/user/" + this.username + "/player";
 console.log("sent.........")
 console.log(url);
 console.log(cPlayer)
 console.log(cPlayer.pid)
return this.http.post(url, cPlayer)
}
getFavoriteList(): Observable<CricPlayer[]> {
this.username = sessionStorage.getItem(USER_NAME) || '{}';
const url = this.favouritEndPoint + "/user/" + this.username + "/getplayerList";
return this.http.get<CricPlayer[]>(url);

} 
deleteFromFavoriteList(cPlayer:CricPlayer)
{
this.username = sessionStorage.getItem(USER_NAME) || '{}';
const url = this.favouritEndPoint + "/user/" + this.username + "/Deleteplayer/"+cPlayer.pid;
return this.http.delete(url);
}

  getSearchPlayer(searchKey:any){
  const url = `${this.searchInfo}${searchKey}`;
  return this.http.get(url);
  }

  getRecommendPlayerList(){
    const headerDict = {
      'Accept': 'application/json, text/plain, */*',
      'Access-Control-Allow-Origin':'*',
      'Content-Type':'application/json',
    }
    const headers = new HttpHeaders(headerDict);
    return this.http.get(`${this.recommendEndPoint}`, {headers});
  }



}
