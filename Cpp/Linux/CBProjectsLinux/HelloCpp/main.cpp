#include <iostream>
#include <limits>
#include <variant>

using namespace std;

int main()
{
    std::cout << "Hello C++" ;
    std::variant<int, std::string> var = "Hello, C++17!";
    std::cout << std::get<std::string>(var) << std::endl;
    std::cin.clear(); // reset any error flags
    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n'); // ignore any characters in the input buffer until we find a newline
    std::cin.get(); // get one more char from the user (waits for user to press enter)

    return 0;
}
