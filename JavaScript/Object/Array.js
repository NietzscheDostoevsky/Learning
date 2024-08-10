let a = [1,"asf", null, true]
console.log(a)

let arr = [10, 20, "hello", ()=>{console.log("executed")}, {name:"tinku"}, [100,200,300] ];
arr[3](); 

let b = new Array(10, 20, 30, 40, "haha")
console.log(b)

console.log(arr[5][2])

//! Array methods 
// ! PUsh pop  shift unshift.   

let numarr = [63, 847, 555, 17, 555, 97, 555, 903, 75];

// for (let i = 0; i < numarr.length; i++) {
//     if(numarr[i] == 555)
//         console.log(i)
// }

// numarr.forEach((val, ind, arr)=>{
//     console.log(val, ind, arr)
// })

for (val in numarr) {
    console.log(val)
}
for (val of numarr) console.log(val)

numarr.map((val, indx, arr) => {
    console.log(val, indx, arr)
})