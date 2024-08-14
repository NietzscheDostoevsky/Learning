let obj1 = {
    name: "Tinku"
}

let obj2 = {
    contacr: 8989898989
}
console.log(obj2.__proto__)
obj2.__proto__ = obj1; 
console.log(obj2.name)
console.log(obj2.__proto__)

let func = () => {
    console.log(this)
}
func();

let obj = {
    name: "Thiku",
    age: 23,
    func1 : () => {
        console.log(this)
    }
    ,
    func2 : function() {
        console.log(this)
        console.log(this.name)
    }
}
obj.func1();
obj.func2();

let func5 = function (name, age ) {
    this.name = name;
    this.age = age; 
}

func5();

let func7 = function (age) {
    console.log(this);
    console.log(age)
}
func7.call(this, 45 )

let obj9 = {}

let func9 = function (name, age, add, contact) {
    this.name = name;
    this.age = age; 
    this.add = add; 
    this.contact = contact; 
}

class func9 {
    constructor(name, age, add, contact) {
        this.name = name;
        this.age = age;
        this.add = add;
        this.contact = contact;
    }
}



func9.call(obj9, "Rinku", 27, "pune", 8989438942)
console.log(obj9)
