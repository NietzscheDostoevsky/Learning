
//! declaring a object using object literal way. 
let car = { 
        brand: "TATA",
        model : "Harrier", 
        price : 120000,
       
};  
        
console.log(`Car company is ${car.brand} and model name is ${car.model} and car price is ${car.price}`);

let person = {
        name : "Kunal", 
        add : "Pune" , 
        designameion: null, 
        gf : undefined , 
        driving : () => {
                console.log("Kunal lovs undefined")
        }
}; 

console.log(person)

//! Creating an object using new keyword.
//! using an object constructor.  

let obj = new Object(); 
console.log(obj); 
obj.name = "Tinku" ; 

console.log(obj)

//! usinc class 

class Person {
        constructor(name, add) {
                this.name = name; 
                this.add = add; 
        }
}

let person1 = new Person("Dimga", "DingiNagar"); 
console.log(person1)

//! Using factory function. 

let Student = (name, add, contact) => {
        let obj = {
                studentName : name, 
                studentAdd: add, 
                studentContact:contact, 
        };
        return obj;
};

let student1 = Student("Tinku", "Pune", 1234567890);
console.log("-------------------")
console.log(student1); 

console.log(Object.keys(student1))

let jsonObj = JSON.stringify(person); 
console.log(jsonObj)

let regularObj = JSON.parse(jsonObj)
console.log(regularObj)

let obj1 = {
        name: "Tinku", 
        add: "Pune"
}

let obj2 = {
        contact : 10987654321
}

let obj3 = obj1 + obj2 // wrong ooutput 
console.log(obj3); 

let obj4 = Object.assign(obj1, obj2); 
console.log(obj4);


