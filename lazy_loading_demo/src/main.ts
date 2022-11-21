import AppDataSource from "./data-source";
import Person from "./Person";
import Order from "./Order";

AppDataSource.initialize().then(() => {

  const personRepository = AppDataSource.manager.getRepository(Person);

  console.log("-------- Get Person --------")
  // @ts-ignore
  personRepository.findOneBy({id: 1}).then((person) => {
    console.log(person);
    console.log(person.orders);

    console.log("-------- Resolve Promise --------")
    // @ts-ignore
    const promise: Promise<Order[]> = person.orders;
    promise.then((orders) => {
      console.log(orders);
    });
    }
  );


}).catch((error) => console.log(error));
