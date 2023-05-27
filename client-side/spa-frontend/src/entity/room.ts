import { Equipment } from "./equipment";

export class Room {
    id!: number;
    roomNo!: number;
    size!: number;
    roomType!: string;
    airConditioner!: boolean;
    capacity!: number;
    privacy!: string;
    avaliable!: boolean;
    equipments!: Equipment[];
}