"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const data_source_1 = require("./data-source");
const Person_1 = require("./Person");
const personRepository = data_source_1.default.manager.getRepository(Person_1.default);
// @ts-ignore
personRepository.findOneBy({ id: 1 }).then((person) => {
    console.log(person);
    console.log(person.orders);
    //(person.orders).then((orders) => {
    //  console.log(orders);
    //});
});
//# sourceMappingURL=main.js.map