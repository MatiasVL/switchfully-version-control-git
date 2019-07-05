import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {Headers, Http, Response} from "@angular/http";
import {Service} from "./service";
import {environment} from "../../../environments/environment";


@Injectable()
export class GolService extends Service {

  private static BASE_PATH = environment.apiUrl;

  constructor(private http: Http) {
    super();
  }

  nextGeneration(world: number[]): Observable<Response> {
    console.log(environment.production);
    return this.http.post(`${GolService.BASE_PATH}/phase`, world,
        {headers: new Headers({"Content-Type": "application/json; charset=utf-8"})});
  }


}
