let gift = "Nokia";
let pinkiPromise = new Promise((resolve, reject) => {
    if(gift === "Iphone") {
        console.log("Gift is Iphone");
        resolve();
    } else {
        reject();
    }
});

pinkiPromise.then(() => {
    console.log("Promise is resolved and gift was iPhone");
}).catch(() => {
    console.log("Promise is rejected and gift was not an iPhone");
});


let p = new Promise((res, rej) => {
    if(gift == "Iphone") {
        res("resolved becasuse gift was iPHone")
    } else {
        rej("rejected because fift is not iphone")
    }
})
p.then((a) => {console.log(a)})
p.catch((b)=> {console.log(b)})