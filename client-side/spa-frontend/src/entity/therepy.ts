import { Equipment } from "./equipment";

export class Therepy {
    id!: number;
    name!: String;
    price!: number;
    duration!: number;
    description!: String;
    benefit!: String;
    equipments!: Equipment[];
}