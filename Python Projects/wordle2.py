import random

def updateAlpha(alphabet, guessed):

    for i in range(5):

        if guessed[i] in alphabet:

            alphabet = alphabet.replace(guessed[i], "_")
    
    return alphabet

    

with open("wordleList.txt") as file:

    num = random.randint(0, 5757)

    for i in range(num):

        word = str(file.readline())

print(word + "\n")

guesses = 0
alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z"
amount = 1

guessed = input("Guess a word: ")

while guessed != word and guesses < 5:

    for i in range(5):
        
        if guessed[i] == word[i]:
            print(guessed[i])
            amount += 1

        elif guessed[i] in word:
            print("!")
        else:
            print("X")

    guesses += 1 
    
    if amount >= 5:

        print(str(guesses) + " guesses! You win! \n")
        break

    alphabet = updateAlpha(alphabet, guessed)
    print(alphabet + "\n")
    guessed = input("Guess a word:")


if (guesses >= 5):

    print("You lose! The word was " + word + "! \n" )

    
