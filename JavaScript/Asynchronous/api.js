fetch("https://api.github.com/users").then((val)=>val.json()).then((api)=>{console.log(api)})

let data = fetch("https://api.github.com/users")
let resp = data.then((val)=>{return val.json})

resp.then((api)=>{console.log(api)})



