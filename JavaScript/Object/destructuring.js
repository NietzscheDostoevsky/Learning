// Extracting out the elements from an array or an object is called destructuring . 


let bagpack = {
    item1: "Torch",
    item2: "Bottle",
    item3: "Charger", 
    item4: "Tiffin",
    item5: "Camera",
    item6: "Lighter" 
}

console.log(bagpack)

let {item1, item2} = bagpack;
console.log(item1)

let arr = ['tourch', 'mobile', 'chocolate', 'charger', 'food']

let [a1, a2, a3] = arr; 
console.log(a1)

let i = arr[3]

let {log} = console;
log("without console")

let str = "india"

//let [a,b,c,d,e] = str; 
//log(a,b,c,d,e)

let arr1 = ['tourch', 'mobile', 'chocolate', 'charger', 'food']
let [a,b,...c] = arr1
log(c)

let nums = [10, 20, 30]
let func = (a,b,c) => {
    log(a + b + c); 
}
func(...nums)

// can use to create a deep copy using spread. 
