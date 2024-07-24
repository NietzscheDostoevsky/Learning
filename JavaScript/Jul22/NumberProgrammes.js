// numberPrograms.js

function generateFibonacciSeries(n) {
    let fibonacciSeries = [0, 1];
    for (let i = 2; i < n; i++) {
        fibonacciSeries.push(fibonacciSeries[i - 1] + fibonacciSeries[i - 2]);
    }
    return fibonacciSeries;
}

function checkAutomorphicNumber(number) {
    let square = number * number;
    return square.toString().endsWith(number.toString());
}

function findPrimeNumbersUpToN(n) {
    let primes = [];
    for (let i = 2; i <= n; i++) {
        let isPrime = true;
        for (let j = 2; j <= Math.sqrt(i); j++) {
            if (i % j === 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            primes.push(i);
        }
    }
    return primes;
}

function calculateFactorial(number) {
    if (number === 0 || number === 1) {
        return 1;
    }
    return number * calculateFactorial(number - 1);
}

function checkArmstrongNumber(number) {
    let digits = number.toString().split('').map(Number);
    let sumOfCubes = digits.reduce((acc, digit) => acc + Math.pow(digit, 3), 0);
    return sumOfCubes === number;
}

function generatePerfectNumbersUpToN(n) {
    let perfectNumbers = [];
    for (let i = 1; i <= n; i++) {
        let sumOfDivisors = 0;
        for (let j = 1; j < i; j++) {
            if (i % j === 0) {
                sumOfDivisors += j;
            }
        }
        if (sumOfDivisors === i) {
            perfectNumbers.push(i);
        }
    }
    return perfectNumbers;
}

function checkPalindromeNumber(number) {
    let str = number.toString();
    return str === str.split('').reverse().join('');
}

function generatePrimeFactors(number) {
    let primeFactors = [];
    for (let i = 2; i <= number; i++) {
        while (number % i === 0) {
            primeFactors.push(i);
            number /= i;
        }
    }
    return primeFactors;
}

function generateLucasSeries(n) {
    let lucasSeries = [2, 1];
    for (let i = 2; i < n; i++) {
        lucasSeries.push(lucasSeries[i - 1] + lucasSeries[i - 2]);
    }
    return lucasSeries;
}

function checkPerfectSquare(number) {
    let sqrt = Math.sqrt(number);
    return sqrt === Math.floor(sqrt);
}

// Example usage of functions
console.log(generateFibonacciSeries(10));
console.log(checkAutomorphicNumber(25));
console.log(findPrimeNumbersUpToN(50));
console.log(calculateFactorial(5));
console.log(checkArmstrongNumber(153));
console.log(generatePerfectNumbersUpToN(10000));
console.log(checkPalindromeNumber(121));
console.log(generatePrimeFactors(56));
console.log(generateLucasSeries(10));
console.log(checkPerfectSquare(49));

