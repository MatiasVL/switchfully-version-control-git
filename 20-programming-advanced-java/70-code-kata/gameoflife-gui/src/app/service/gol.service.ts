import {Injectable} from "@angular/core";
import {Service} from "./service";
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from "../../environments/environment";


@Injectable()
export class GolService extends Service {

  private static BASE_PATH = "api/gol";

  constructor(private http: HttpClient) {
    super();
  }

  nextGeneration(world: number[]): Observable<number[]> {
    return this.http.post<number[]>(`${environment.apiUrl}/${GolService.BASE_PATH}/phase`, world,
        {headers: new HttpHeaders({"Content-Type": "application/json; charset=utf-8"})});
  }


}
