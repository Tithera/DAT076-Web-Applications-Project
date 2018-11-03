/*
   utility for MVC

  will send data to gui from model 
  so will be controller

   responsible for this class: Emilia Vestlund

*/
class EventBus {

  constructor() {
    this.observers = [];
  }

//will register to the model
  register(observer) {
    this.observers.push(observer);
  }
//will unregister to the model

  unregister(observer) {
    let slice = observers.indexOf(observer);
    this.observers.slice(slice, 1);
  }

    //will notify the gui
  notify(eventDB, dataDB) {
    this.observers.forEach(function(observer) {
      observer.onModelEvent(eventDB, dataDB);
    });
  }

}

export const eventBus = new EventBus();
