let obj = {
    name: "Tinkku", 
    add : "Pune"
}; 

delete obj.add // delete is an oerator 
console.log(obj)

let obj2 = {
    name: "Tinkku", 
    add : "Pune"
}; 

Object.freeze(obj2); 
//obj2.contact = 123457890;
console.log(obj2) //! we can't add new property when object if freezed. 

//delete obj2.add 
console.log(obj2) //! we can't delte the existing proprties from a freezed object. 

console.log(Object.isFrozen(obj2))

let obj3 = {
    name: "Tinkku", 
    add : "Pune"
}; 

Object.seal(obj3); 
//obj3.contact = 12332; //!can modoify a sealed object , but can modify existing properties in an object. 
console.log(obj3) 