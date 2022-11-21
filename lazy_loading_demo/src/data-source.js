"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const typeorm_1 = require("typeorm");
const dotenv = require("dotenv");
const Person_1 = require("./Person");
const Order_1 = require("./Order");
dotenv.config({ path: '../.env' });
const AppDataSource = new typeorm_1.DataSource({
    type: 'postgres',
    host: 'localhost',
    port: 5432,
    username: 'postgres',
    password: 'postgres',
    database: 'typeorm',
    synchronize: true,
    logging: true,
    entities: [
        Person_1.default,
        Order_1.default,
    ],
    subscribers: [],
    migrations: [],
});
exports.default = AppDataSource;
//# sourceMappingURL=data-source.js.map