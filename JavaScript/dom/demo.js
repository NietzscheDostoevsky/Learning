// let myDiv = document.getElementById('myDiv')
// console.log(myDiv)

// let myDiv =  document.getElementsByClassName('myDiv')
// console.log(myDiv)

// let elements = document.getElementsByTagName("main")
// console.log(elements)

// let element = document.querySelector('#firstDiv')
// console.log(element)

let elements = document.querySelector('#firstele')
console.log(elements.style.background)
elements.style.color = 'yellow'
elements.style.height = '50px'

let para = document.createElement('p');
console.log(para)
para.innerText = "I am paragraph"

elements.append(para)