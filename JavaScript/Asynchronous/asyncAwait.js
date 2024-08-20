

let fetchAPI = async() => {
    let resp = await fetch("https://api.github.com/users")
    let api = await resp.json();
    console.log(api)
}
fetchAPI(); 