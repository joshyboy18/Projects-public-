const stylesheet = document.createElement('style');
const comp_buttons = {

    github: document.createElement('button'), resume: document.createElement('button'), hslc: document.createElement('button'), olympics: document.createElement('button'), miracle: document.createElement('button')
};

rightClick = 0;
currStatement = organizations();
slideStatement = RPC();
clickCount = 0;
num = 0;
// for the computer button
function clickComputer(button) {

    clickCount += 1;
    num += 1;

    switch (button) {

        case "computer":

            if (clickCount % 2 == 1) {
        
            document.getElementById('div_choices').appendChild(comp_buttons.github);
            document.getElementById('div_choices').appendChild(comp_buttons.resume);
            comp_buttons.github.classList.add('github-button');
            comp_buttons.resume.classList.add('resume-button');
        
            
            }

            else {

                removeButtons("computer");
            }

            break;
        
        case "orgs":

            if (num % 2 == 1) {

                document.getElementById('div_choices_two').appendChild(comp_buttons.hslc);
                document.getElementById('div_choices_two').appendChild(comp_buttons.olympics);
                document.getElementById('div_choices_two').appendChild(comp_buttons.miracle);
                comp_buttons.hslc.classList.add('hslc-button');
                comp_buttons.miracle.classList.add('miracle-button');
                comp_buttons.olympics.classList.add('olympics-button');

            }

            else {

                removeButtons("orgs");
            }
        default: 
            break;
        }

        

        eventHappens();
}

    

function eventHappens() {

            comp_buttons.github.addEventListener("click", gitClick);
            comp_buttons.resume.addEventListener("click", resumeClick);
            comp_buttons.hslc.addEventListener("click", hslcClick);
            comp_buttons.miracle.addEventListener("click", miracleClick);
            comp_buttons.olympics.addEventListener("click", olympicsClick);
            


           
}

function hslcClick() {

    window.open("https://www.ou.edu/sga/cac/high-school-leadership-conference", "_ blank");
}
function resumeClick() {

    window.open("https://docs.google.com/document/d/1N954Mw3ynmrk2b1omylAVd4Q4Z-MUWGVKqig41E5Kzk/edit?tab=t.0", "_ blank");
}


function gitClick() {

    window.open("https://github.com/joshyboy18/Projects", "_ blank");

}

function miracleClick() {

    window.open("https://ou.campuslabs.com/engage/organization/miracle-mindset-college-access-program", "_ blank");

}

function olympicsClick() {

    window.open("https://www.sook.org/what-we-do/competitions/", "_ blank");
}

function adjustButtons() {

    document.getElementById("github_button").style.marginTop = "10px";
    document.getElementById("code_button").style.marginTop = "10px";

}

function readjustButtons() {

    
}

function removeButtons(text) {

    if (text == "computer") {

        comp_buttons.github.remove();
        comp_buttons.resume.remove(); 
    }

    else {

        comp_buttons.hslc.remove();
        comp_buttons.olympics.remove();
        comp_buttons.miracle.remove();
    }

}

function clickRightArrow() {
    
    if (currStatement == organizations()) {

        currStatement = programming();
        document.getElementById("information").innerHTML = currStatement;
        document.getElementById("div_about").style.backgroundColor = "lightblue";
    }

    else if (currStatement == programming()) {
        
        currStatement = introduction();
        document.getElementById("information").innerHTML = currStatement;
        document.getElementById("div_about").style.backgroundColor = "white";
    }

    else if (currStatement == introduction()) {

        currStatement = organizations();
        document.getElementById("information").innerHTML = currStatement;
        document.getElementById("div_about").style.backgroundColor = "yellow";
    }
}

function clickLeftArrow() {

    if (currStatement == organizations()) {

        currStatement = introduction();
        document.getElementById("information").innerHTML = currStatement;
        document.getElementById("div_about").style.backgroundColor = "white";
    }

    else if (currStatement == programming()) {
        
        currStatement = organizations();
        document.getElementById("information").innerHTML = currStatement;
        document.getElementById("div_about").style.backgroundColor = "yellow";
    }

    else if (currStatement == introduction()) {

        currStatement = programming();
        document.getElementById("information").innerHTML = currStatement;
        document.getElementById("div_about").style.backgroundColor = "lightblue";
    }
}

function slideInfoRight() {

    if (slideStatement == RPC()) {

        slideStatement = Chess();
        document.getElementById("projects-info").innerHTML = slideStatement;
        document.getElementById("div_images").style.backgroundImage = "url(images/chess2.png)";
        document.getElementById("div_images").style.backgroundSize = "cover";
    }   

    else if (slideStatement == Chess()) {

        slideStatement = MarioParty2();
        document.getElementById("projects-info").innerHTML = slideStatement;
        document.getElementById("div_images").style.backgroundImage = "url(images/MarioParty2.png)";
        document.getElementById("div_images").style.backgroundSize = "cover";
    }

    else if (slideStatement == MarioParty2()) {

        slideStatement = wordle();
        document.getElementById("projects-info").innerHTML = slideStatement;
        document.getElementById("div_images").style.backgroundImage = "url(images/wordle.png)";
        document.getElementById("div_images").style.backgroundSize = "cover";

    }

    else if (slideStatement == wordle()) {

        slideStatement = RPC();
        document.getElementById("projects-info").innerHTML = slideStatement;
        document.getElementById("div_images").style.backgroundImage = "url(images/PokeSite.png)";

    }

}

function slideInfoLeft() {

    if (slideStatement == RPC()) {

        slideStatement = wordle();
        document.getElementById("projects-info").innerHTML = slideStatement;
        document.getElementById("div_images").style.backgroundImage = "url(images/wordle.png)";
        document.getElementById("div_images").style.backgroundSize = "cover";
    }

    else if (slideStatement == Chess()) {
            
            slideStatement = RPC();
            document.getElementById("projects-info").innerHTML = slideStatement;
            document.getElementById("div_images").style.backgroundImage = "url(images/PokeSite.png)";
    }

    else if (slideStatement == MarioParty2()) {

        slideStatement = Chess();
        document.getElementById("projects-info").innerHTML = slideStatement;
        document.getElementById("div_images").style.backgroundImage = "url(images/chess2.png)";
        document.getElementById("div_images").style.backgroundSize = "cover";
    }

    else if (slideStatement == wordle()) {

        slideStatement = MarioParty2();
        document.getElementById("projects-info").innerHTML = slideStatement;
        document.getElementById("div_images").style.backgroundImage = "url(images/MarioParty2.png)";
        document.getElementById("div_images").style.backgroundSize = "cover";
    }

    else if (slideStatement == RPC()) {

        slideStatement = wordle();
        document.getElementById("projects-info").innerHTML = slideStatement;
        document.getElementById("div_images").style.backgroundImage = "url(images/wordle.png)";
        document.getElementById("div_images").style.backgroundSize = "cover";
    }


}

function organizations() {

    return "I am in various organizations on campus. The current ones I am in include HSLC, Miracle Mindset, and OU's Unified Olympics. These organizations focus on philantrohpy and helping the younger generation dvelop as leaders.";
}

function programming() {

    return "Programming is a skill that I have been developing for the past 3 years. I have experience in Java, Python, C#, C++, HTML, CSS, and JavaScript. I understand principles in both object-oriented and functional programming paradigms. I have programmed various projects of my own that can be found in the github and below, and will continue to develop more projects to come.";
}

function introduction() {

    return "Hi! My name is Joshua Robinson, a computer science student at the University of Oklahoma. I'm a hardworking student who excels in various programming languages, including C++, java, javascript, python, and much more. I also excel in the areas of critical-thinking, teamwork, reliability, intelligence, creativity, and motivation. I am excited to have you here and hope you enjoy learning more about who I am. On the left is a button referencing all my programming and resume information. The right button directs you to the various website of my campus involvement. Finally, click the arrows to move the slides to learn where I come from. Enjoy!";
}

function RPC() {

    return "This is my first HTML project of a pokemon/rock paper scissors game. You pick a pokemon type and the computer will choose one, determining whether you win or lose. It also has a win and lose percentage to look at, but you can restart the game whenever you want!";
}

function Chess() {

    return "This is my Chess program in C++. It is a terminal game that uses coordinates to determine where each of the pieces moves. It also has all the rules in chess and turn orders to make sure the players are playing fair!";
}

function MarioParty2() {

    return "This is my java project that is a mini version of Mario Party. It is a text-based game that has 4 players and some mini-games. The player with the most stars at the end wins!";
}

function wordle() {

    return "This is my version of Wordle in Python. It is a terminal game that has you guess a 5-letter word in 6 tries. It also has a hint system to help you out!";
}


