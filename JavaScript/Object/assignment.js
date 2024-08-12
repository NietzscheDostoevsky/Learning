

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

// 9. 

function filterArray(arr, func) {
    return func(arr);
}

console.log(filterArray([1, 2, 3, 4, 5], (arr) => {
    let retArr = [];
    arr.forEach(element => {
        if (element % 2 == 0)
            retArr.push(element);
    });
    return retArr;
}));

// 10. 

function mapArrayElements(func, arr) {
    let retArr = [];
    arr.forEach(element => {
        retArr.push(func(element));
    });
    return retArr;
}

// 11

(() => (console.log("Hello world")))();

//12. 
((x, y) => (console.log(x + y)))(10, 5);

// 13.

console.log((() => {
    let obj = {
        currentDate: new Date().toLocaleDateString(),
        currentTime: new Date().toLocaleTimeString()
    };
    return obj;
})());

// 14. 

const counter = (() => {
    let count = 0;
    return {
        increment: () => (count++),
        getValue: () => (count)
    };
})();

console.log(counter.getValue()); // Output: 0
counter.increment();
console.log(counter.getValue()); // Output: 1
counter.increment();
counter.increment();
console.log(counter.getValue()); // Output: 3