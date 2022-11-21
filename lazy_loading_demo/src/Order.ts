import {Column, Entity, ManyToOne, PrimaryGeneratedColumn} from "typeorm";
import Person from './Person';

@Entity()
class Order {
  @PrimaryGeneratedColumn()
  private id: number;

  @Column()
  private product: string;

  @Column()
  private amount: number;

  @Column()
  private price: number;

  @ManyToOne(() => Person, (person) => person.orders)
  person: Person;
}

export default Order;
