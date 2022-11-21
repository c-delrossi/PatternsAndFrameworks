import { DataSource } from 'typeorm';
import * as dotenv from 'dotenv';
import Person from "./Person";
import Order from "./Order";

dotenv.config({ path: '../.env' });

const AppDataSource = new DataSource({
  type: 'postgres',
  host: 'localhost',
  port: 5432,
  username: 'postgres',
  password: 'postgres',
  database: 'typeorm',
  synchronize: true,
  logging: true,
  entities: [
    Person,
    Order,
  ],
  subscribers: [],
  migrations: [],
});

export default AppDataSource;
