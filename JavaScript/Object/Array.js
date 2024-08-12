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

console.log("_____________________________")
let nums = [190, 380, 220, 301, 870, 667, 7]
let newnums = nums.sort();
console.log(newnums)

let sortnums = numarr.sort((a,b)=> {
    return a-b;
})
console.log(sortnums)

let newArr = [];
//let numarr = [5, 2, 9, 1, 5, 6]; // Example array to sort

for (let i = 0; i < numarr.length; i++) {
    for (let j = 0; j < numarr.length - i - 1; j++) {
        if (numarr[j] > numarr[j + 1]) {
            // Swap the elements
            let temp = numarr[j];
            numarr[j] = numarr[j + 1];
            numarr[j + 1] = temp;
        }
    }
}

console.log(numarr); // Output the sorted array


let c = numarr.filter((val, i)=> {
    return val!==555;
})
console.log(c)

let users = [
    {
        name: "tinku",
        id: 1
    } , 
    {
        name: "pinku",
        id: 2
    } , 
    {
        name: "rinku",
        id: 3
    } , 
    {
        name: "kinku",
        id: 4
    } , 
    {
        name: "rinku",
        id: 5
    } 
]

let updatedArr = users.filter((val) => {
    return val.id !== 2;
})

console.log(updatedArr);

console.log(nums.find((val, i) => {
    if(val == 380)
        return i;
}));

// find () will not return index, only the element. 

let arr3 = [10, 20, 30, 40, 20] 
let a2 = arr3.reduce((sum, val) => {
    return sum += val;
});
console.log("-----------------")
console.log(a2);
