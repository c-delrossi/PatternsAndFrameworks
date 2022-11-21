"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
const typeorm_1 = require("typeorm");
const Person_1 = require("./Person");
let Order = class Order {
    id;
    product;
    amount;
    price;
    person;
};
__decorate([
    (0, typeorm_1.PrimaryGeneratedColumn)()
], Order.prototype, "id", void 0);
__decorate([
    (0, typeorm_1.Column)()
], Order.prototype, "product", void 0);
__decorate([
    (0, typeorm_1.Column)()
], Order.prototype, "amount", void 0);
__decorate([
    (0, typeorm_1.Column)()
], Order.prototype, "price", void 0);
__decorate([
    (0, typeorm_1.ManyToOne)(() => Person_1.default, (person) => person.orders)
], Order.prototype, "person", void 0);
Order = __decorate([
    (0, typeorm_1.Entity)()
], Order);
exports.default = Order;
//# sourceMappingURL=Order.js.map