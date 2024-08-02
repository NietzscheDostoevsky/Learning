console.log("haha")
let movie = "  Zindagi na milegi dubara!!!    "
console.log(movie)
console.log(movie.trimStart())
console.log(movie.trim())
console.log(movie)

let char = "8383" 
// let padStart = "XXXXXX"
// let mobileNo = padStart + char
// console.log(mobileNo)

console.log(char.padStart(10, "*"))
console.log(char.padEnd(10, "x"))

let str = "Hello\n" 
// for (let i = 0; i < 10; i++) {
//     console.log("Hello")
// }

console.log(str.repeat(10))
let haha = "Saurabh Singh"
let newName = haha.split("");
console.log(newName);

(() => {
    alert("Kya aap cookies accept karna chahoge")
})()


