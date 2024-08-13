// Ques 1

a1 = [2, 4, 6, 8, 10]; 
a1.forEach((element, index) => {
    console.log(element, index)
});

a1Fruit = ['mango', 'banana', 'pineapple', 'blueberry', 'papaya']
a1Fruit.forEach((element, index) => {
    console.log("I like " + element )
})

console.log("---------------------")

//2.  
a2color = ['red', 'blue', 'black', 'white', 'green']
for ( index in a2color) {
    console.log(`Index: ${index} , Color: ${a2color[index]}`)
}

a2 = [2, 4, 6, 8, 10]; 
for (index in a2) {
    let element = a2[index];
    a2[index] = element * 2; 
}
console.log(a2)

console.log("---------------------")

// 3. 

a3Country = ["india", 'us', 'aus', 'ger', 'fra']
for (country of a3Country) {
    console.log(country)
}

a3 = ["Good Morning", "Good Night", "Hello", "Goodbye"]
for (greeting of a3) {
    console.log(greeting + "!")
}
console.log("---------------------")

// 4. 

a4 = [15, 3, 9, 25, 7]; 
a4.sort((a,b)=>a-b)
console.log(a4)

a4city = ['delhi', 'pune', 'mumbai', 'chandigarh', 'gurgaon', 'punjab'];
a4city.sort()
console.log(a4city)

console.log("---------------------")


a5 = [3, 10, 18, 20, 25]; 
console.log(a5.find((element) => (element > 15)))

a5animals = ['gaot', 'lion', 'elephant', 'squrerel', 'cat']
console.log(a5animals.find((element)=>{
    return element.length > 5;
}))

console.log("---------------------")

// 6. 
a6 = [1, 2, 3, 4, 5];
console.log(a6.map((x)=>(x*x)))

a6fruit = ["apple", "banana", "cherry"]; 

console.log(a6fruit.map((x)=>x.toUpperCase()))

console.log("---------------------")

// 7. 

a7 = [5, 8, 13, 21, 34]; 
console.log(a7.filter((x)=> (x>10)))

a7words = ['hello', 'how', 'are','today','on','this','fine','day']
console.log(a7words.filter((word)=>{
    return !word.includes('e')
}))

console.log("---------------------")

// 8. 

a8 =  [3, 4, 7, 12, 19]; 
console.log(a8.reduce((a,b)=>(a+b)))

a8stirng = ["I", "love", "coding"];
console.log(a8stirng.reduce((a,b)=>(a+b)))

console.log("---------------------")

//9. 

a9 = [2, 5, 8, 11, 14];
console.log(a9.map((x)=>(x*x)).filter((x)=>(x>10)))

a9nums = [3, 6, 9, 12];
console.log(a9nums.map((x)=>(x+2)).reduce((a,b)=>(a*b)))
console.log("---------------------")

//10. 

a10 = [8, 3, 12, 1, 7];
console.log(a10.sort((a,b)=>(a-b)).map((a)=>(a-1)))

a10nums = [2, 4, 6, 8, 10, 13, 11]; // op = 24
console.log(a10nums.filter((a)=>(a%2 !=0)).reduce((a,b)=>(a+b)))
