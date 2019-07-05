import {Component, OnInit} from '@angular/core';
import {GolService} from "./service/gol.service";
import {interval, Subscription} from "rxjs";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  public isEvolutionEnabled: boolean;
  public evolutionIteration: Subscription;
  public worldService: GolService;
  public world: number[];
  public worldDimension: number;
  public numberOfCalls: number;

  constructor(worldService: GolService) {
    this.worldService = worldService;
  }

  ngOnInit() {
    this.initializeWorld(AppComponent.emptyWorld(10));
    this.isEvolutionEnabled = false;
    this.numberOfCalls = 0;
  }

  public initializeWorld(arr): void {
    this.world = arr;
    this.worldDimension = arr.length;
  };

  startEvolution(): void {
    this.isEvolutionEnabled = true;
    const everySecond = interval(1000);
    this.evolutionIteration = everySecond.subscribe(() => {
      this.worldService.nextGeneration(this.world)
        .subscribe((evolvedWorld: number[]) => {
          this.numberOfCalls++;
          this.world = evolvedWorld;
        });
    });
  };

  stopEvolution(): void {
    this.evolutionIteration.unsubscribe();
    this.isEvolutionEnabled = false;
  };

  getNextStatusOfWorld(): void {
    this.worldService.nextGeneration(this.world)
      .subscribe((evolvedWorld: number[]) => {
        this.numberOfCalls++;
        this.world = evolvedWorld;
      });
  };

  toggleCell(column, row): void {
    this.world[row][column] = !this.world[row][column];
  };

  addDimension(amount: number): void {
    const newDimension = this.worldDimension + amount;
    this.initializeWorld(AppComponent.emptyWorld(newDimension <= 40 ? newDimension : 40));
  };

  removeDimension(amount: number): void {
    const newDimension = this.worldDimension - amount;
    this.initializeWorld(AppComponent.emptyWorld(newDimension >= 3 ? newDimension : 3));
  };

  private static emptyWorld(dimension): number[] {
    let arr = [];
    for (let i = 0; i < dimension; i++) {
      arr[i] = [];
      for (let j = 0; j < dimension; j++) {
        arr[i][j] = false;
      }
    }
    return arr;
  }

  blinker(): any {
    return [
      [false, false, false],
      [true, true, true],
      [false, false, false]
    ];
  };

  pulsar(): any {
    let D = false;
    let L = true;

    return [
      [D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D],
      [D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D],
      [D, D, D, D, L, L, L, D, D, D, L, L, L, D, D, D, D],
      [D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D],
      [D, D, L, D, D, D, D, L, D, L, D, D, D, D, L, D, D],
      [D, D, L, D, D, D, D, L, D, L, D, D, D, D, L, D, D],
      [D, D, L, D, D, D, D, L, D, L, D, D, D, D, L, D, D],
      [D, D, D, D, L, L, L, D, D, D, L, L, L, D, D, D, D],
      [D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D],
      [D, D, D, D, L, L, L, D, D, D, L, L, L, D, D, D, D],
      [D, D, L, D, D, D, D, L, D, L, D, D, D, D, L, D, D],
      [D, D, L, D, D, D, D, L, D, L, D, D, D, D, L, D, D],
      [D, D, L, D, D, D, D, L, D, L, D, D, D, D, L, D, D],
      [D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D],
      [D, D, D, D, L, L, L, D, D, D, L, L, L, D, D, D, D],
      [D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D],
      [D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D]
    ];
  };

}
