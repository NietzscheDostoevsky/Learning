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

// 3. 

a3Country = ["india", 'us', 'aus', 'ger', 'fra']
for (country of a3Country) {
    console.log(country)
}

a3 = ["Good Morning", "Good Night", "Hello", "Goodbye"]
for (greeting of a3) {
    console.log(greeting + "!")
}
