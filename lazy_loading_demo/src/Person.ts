import {Column, Entity, OneToMany, PrimaryGeneratedColumn} from 'typeorm';
import Order from "./Order";

@Entity()
class Person {
  @PrimaryGeneratedColumn()
  private id: number;

  @Column()
  private name: string;

  @OneToMany(() => Order, order => order.person, { lazy: true })
  orders: Order[];
}

export default Person;
