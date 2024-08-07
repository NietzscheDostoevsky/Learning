// console.log("hello")
// let a = 20; 
// console.log(a); 
// let b = 30; 
// console.log(b); 
// console.log("end");
// console.log(a);
// var a = 20; 
// console.log(window); 

let func = ()=> {
    let a = 20; 
    let internalFunc = () => {
        console.log(a);
    }
    internalFunc();
}
func();
