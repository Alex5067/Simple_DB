#include <iostream>
#include <map>
#include <thread>
#include <mutex>

std::map<int, std::string> phrases;
std::mutex mutex;

void chandler_says() 
{
    mutex.lock();
    phrases[2] = "Chandler: Hey.";
    phrases[3] = "Chandler: And this from the cry-for-help department. Are you wearing makeup?";
    phrases[5] = "Chandler: That's so funny, 'cause I was thinking you look more like Joey Tribbiani, man slash woman.";
    phrases[11] = "Chandler: Good luck, man. I hope you get it.";
    mutex.unlock();
}

void phoebe_says() 
{
    mutex.lock();
    phrases[1] = "Phoebe: Hey.";
    phrases[7] = "Phoebe: What were you modeling for?";
    phrases[9] = "Phoebe: You know, the asthma guy was really cute.";
    mutex.unlock();
}

void joey_says() 
{
    mutex.lock();
    phrases[0] = "Joey: Hey, hey.";
    phrases[4] = "Joey: Yes, I am. As of today, I am officially Joey Tribbiani, actor slash model.";
    phrases[6] = "Joey: You know those posters for the City Free Clinic?";
    phrases[10] = "Joey: No, but I hear lyme disease is open, so... (crosses fingers)";
    phrases[12] = "Joey: Thanks.";
    mutex.unlock();
}

void monica_says() 
{
    mutex.lock();
    phrases[8] = "Monica: Oh, wow, so you're gonna be one of those \"healthy, healthy, healthy guys\"?";
    mutex.unlock();
}

int main() {
    std::thread chandler(chandler_says);
    std::thread phoebe(phoebe_says);
    std::thread joey(joey_says);
    std::thread monica(monica_says);

    chandler.join();
    phoebe.join();
    joey.join();
    monica.join();

    for (const auto &[key, value] : phrases)
        std::cout << value << std::endl;
    return 0;
}

