"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const data_source_1 = require("./data-source");
const Person_1 = require("./Person");
data_source_1.default.initialize().then(() => {
    const personRepository = data_source_1.default.manager.getRepository(Person_1.default);
    console.log("-------- Get Person --------");
    // @ts-ignore
    personRepository.findOneBy({ id: 1 }).then((person) => {
        console.log(person);
        console.log(person.orders);
        console.log("-------- Resolve Promise --------");
        // @ts-ignore
        const promise = person.orders;
        promise.then((orders) => {
            console.log(orders);
        });
    });
}).catch((error) => console.log(error));
//# sourceMappingURL=main.js.map