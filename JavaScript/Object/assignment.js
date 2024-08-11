function sumNumbers(num1, num2) {
    return num1 + num2
}

console.log(sumNumbers(1, 3));

// 7. 

function applyTwice(func, num) {
    return func(func(num))
}

let func = (x) => (x + 3)
console.log(func(5))

console.log(applyTwice(func, 5))

//. 8 

function executeAfterDelay(func2, delayTime) {
    setTimeout(func2, delayTime)
}
executeAfterDelay(() => {
    console.log("This message is displayed after 2 seconds.");
}, 2000);

// 