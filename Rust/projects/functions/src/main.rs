fn main() {
   println!("Hello, haha");

    another_function(43);
    print_labeled_measurements(5, '❤');
}

fn another_function(input: i32) {
    println!("another functino huey huey input {input}");
}

fn print_labeled_measurements(num: i32, ch: char) {
    println!("The measurement is {num}: {ch}");
}