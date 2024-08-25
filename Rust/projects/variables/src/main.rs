use std::io;
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
    println!("Y again in outer scope is {}", y);

    let guess: i32 = "43".parse().expect("Not a number");

    let a = 43;
    let b = 65isize;
    let b = 434i32;

    let f = 2.0;
    let f: f32 = 2.0;
    let heart_eyed_cat = '😻';
    let a = [1, 2, 3, 4, 5,];

    let a = [3;5];

    let a = [1,2,3,4,5];
    println!("Please enter an array index: ");

    let mut index = String::new();
    io::stdin().read_line(&mut index).expect("Failed to read line");

    let index: usize = index.trim().parse().expect("Index entered is note a number");
    let element = a[index];
    println!("the value oof the element at index {index} is : {element}");

}
