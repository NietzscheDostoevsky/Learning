console.log("Start")

setTimeout(() => {
    console.log("Haha")
}, 5000);

setInterval(() => {
    console.log("Code is executing")
}, 1000)

console.log("End")

let i = 0;
const myInterval = setInterval(() => {
    i++;
    console.log(i);
    
    if (i === 5) {
        clearInterval(myInterval);
    }
}, 2000);

let j = 0; 
let interval = setInterval(() => {
    if (j == 5) clearInterval(interval); 
    console.log(j)
    j++
}, 2000)

// async await 