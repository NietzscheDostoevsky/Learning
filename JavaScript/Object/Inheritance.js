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
