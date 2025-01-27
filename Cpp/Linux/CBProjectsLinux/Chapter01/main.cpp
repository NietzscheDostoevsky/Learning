#include <iostream>
#include <limits>

//int main() { std::cout << "Hello World"; return 0;} // would work just fine.

int main()
{
    std::cout << "Hello workd from proper formatting \n";

    int width;
    width = 5;
    std::cout << width << std::endl ;
    std::cout << "\n";
    int length {6}; // brace initialization, prevents narrowing conversions, enforces type safety
    std::cout << length << "\n";

    // Maybe unused attribue.
    [[maybe_unused]] double pi { 3.14159}; // doesn't complains if pi is unsed
    [[maybe_unused]] double phi { 1.61803};
    std::cout << phi << std::endl;

    std::cout << "Enter a number : " ;
    int x {};
    std::cin >> x;
    std::cout << "You entered " << x << '\n';
    int y {}, z {};
    std::cout << "Enter two numbers separated by space : " ;
    std::cin >> y >> z;
    std::cout << "You entered : y = " << y << " and z = " << z << std::endl;

    std::cout << "Enter two numbers , a and b : ";
    int a {};
    std::cin >> a;
    int b {};
    std::cin >> b;

    std::cout << "You entered " << a << " and " << b << '\n';

    // Code so console does't closes on its own
    std::cin.clear(); // reset any error flags
    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
    std::cin.get();

    return 0;
}

