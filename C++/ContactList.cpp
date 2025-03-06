#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <unordered_map>
#include <fstream>


using namespace std;

struct Contact
{
    string name;
    string business;
    string address;
    string email;
    string website;
    string phoneNum;
    string mobileNum;

};

vector<Contact> sortConcacts(vector<Contact> contacts) {

    vector<Contact> sortedContacts(contacts.size());
    bool swapped = false;
    Contact temp;
    int j;

    for (int i = 0; i < contacts.size() - 1; ++i) {
        int k = 0;
        j = 0;

        while (j < contacts.size() - 1 - i) { 
            
            if (contacts[j].name[k] > contacts[j + 1].name[k]) {

                cout << "Swapping" << endl;

                cout << contacts[j].name << endl;
                cout << contacts[j + 1].name << endl;

                temp = contacts[j];
                contacts[j] = contacts[j + 1];
                contacts[j + 1] = temp;
                swapped = true;
                k = 0; // Reset the index
                ++j;
            }

            else if (contacts[j].name[k] == contacts[j + 1].name[k]) {
                
                ++k; // Move to the next character

            }

            else {
                k = 0; // Reset the index
                ++j; // Move to the next contact
            }
        }

        if (!swapped) {
            break;
        }
    }

    sortedContacts = contacts;
    return sortedContacts;
}

void displayInfo(unordered_map<string, Contact> contacts, string answer) {

    cout << "Name: " << contacts[answer].name << endl;
    cout << "Business: " << contacts[answer].business << endl;
    cout << "Address: " << contacts[answer].address << endl;
    cout << "Email: " << contacts[answer].email << endl;
    cout << "Website: " << contacts[answer].website << endl;
    cout << "Phone Number: " << contacts[answer].phoneNum << endl;
    cout << "Mobile Number: " << contacts[answer].mobileNum << endl;

}

int main() {

    string business, name, address, email, website, phoneNum, mobileNum, space;
    char temp;
    
    ifstream reading;
    reading.open("phonebook.txt");

    if (!reading.is_open()) {
        cerr << "Error: Could not open the file." << endl;
        return 1;
    }

    Contact contact;

    unordered_map<string, Contact> contacts;
    int index = 0;
    
    while(index < 3) {
        
        reading >> business;
        reading >> temp;

        getline(reading, business);
        cout << business << endl;
        business.insert(0, 1, temp); // Insert the space back into the string
        cout << business << endl;


        reading >> name;
        reading >> temp;

        getline(reading, name);
        name.insert(0, 1, temp);

        reading >> address;
        reading >> temp;


        getline(reading, address);
        address.insert(0, 1, temp); // Insert the space back into the string


        reading >> phoneNum;
        reading >> temp; // This is to get rid of the space

        
        reading >> phoneNum;
        phoneNum.insert(0, 1, temp);


        reading >> mobileNum;
        reading >> temp;
        

        reading >> mobileNum;
        mobileNum.insert(0, 1, temp);


        reading >> email;
        reading >> temp;


        getline(reading, email);
        email.insert(0, 1, temp);


        reading >> website;
        reading >> temp;

        getline(reading, website);
        website.insert(0, 1, temp);

        contact.name = name;
        contact.address = address;
        contact.email = email;
        contact.website =  website;
        contact.phoneNum = phoneNum;
        contact.business = business;

        contact.mobileNum = mobileNum;

        contacts[name] = contact;
        ++index;
    }

    index = 0;
    vector<Contact> contactList(3);

    for (const auto& entry : contacts) {

        contactList[index] = entry.second; // Copy the contact to the vector

        ++index;
    }

    cout << contacts["Joshua Robinson"].name << endl;
    string answer;

    cout << "Whose contact info do you want to search for?" << endl;
    cin >> answer;

    displayInfo(contacts, answer);

    reading.close();

    return 0;
}