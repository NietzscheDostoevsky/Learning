fn main() {
    let mut x = 5;
    println!("The value of x is: {x}");
    x = 54;
    println!("The value of x is: {x}");

    const THREE_HOURS_IN_SECONDS: u32 = 60 * 60 * 3;
    println!("{}", THREE_HOURS_IN_SECONDS);

    let y = 6;
    let y = y + 1;

    println!("The value if y is: {}", y);

    {
        let y = y * 2;
        println!("Y inside inner scope is : {}", y);
    }
    println!("Y again in outer scope is {}" , y);
}