const reset_button = document.createElement('button');
const fire = document.createElement('img');
const water = document.createElement('img');
const grass = document.createElement('img');

const waterCopy = document.createElement('img');
const fireCopy = document.createElement('img');
const grassCopy = document.createElement('img');

const blastoise = document.getElementById('water_button');
const charizard = document.getElementById('fire_button');
const venusaur = document.getElementById('grass_button');
fire.src = 'images/fire.png';
water.src = 'images/water.png';
grass.src = 'images/grass.png';

fireCopy.src = 'images/fire.png';
waterCopy.src = 'images/water.png';
grassCopy.src = 'images/grass.png';

let info = '';
let end = '';

let userInfo = {
    
    userWin: 0, userLoss: 0, draw: 0

};

function getComputerChoice() {

    let randomNum = Math.floor(Math.random() * 3 + 1); // 1, 2, 3

        switch (randomNum) {

            case 1:
                return 'Water';
                break;
            
            case 2:
                return 'Fire';
                break;
            case 3: 
                return 'Grass';
                break;
            default:

                break;
            
        }
    }
    
    function result(userChoice) {

        
        let compChoice = getComputerChoice();

        if (userChoice == 'Water') {

            
            switch (compChoice) {

                case 'Water':
                    RemoveButtons();
                    duplicateType('water');
                    adjustScore();
                    leftPic = 'water';
                    userInfo.draw++;
                    info = 'Water is even against Water';
                    end = 'tied!';
                    break;
                
                case 'Fire':
                    RemoveButtons();
                    addLeftPic('water');
                    addRightPic('fire'); 
                    adjustScore(); 
                    userInfo.userWin++;
                    info = 'Water beats fire';
                    end = 'won!';
                    break;
                
                case 'Grass':
                    RemoveButtons();
                    addLeftPic('grass');
                    addRightPic('water');
                    adjustScore();
                    userInfo.userLoss++;
                    info = 'Water is weak against Grass';
                    end = 'lost...';
                    break;
            }
        }

        else if (userChoice == 'Fire') {

            switch (compChoice) {

                case 'Water':
                    RemoveButtons();
                    addLeftPic('water');
                    addRightPic('fire'); 
                    adjustScore();   
                    userInfo.userLoss++;
                    info = 'Fire is weak against Water';
                    end = 'lost...';
                    break;
                
                case 'Fire':

                    RemoveButtons();
                    duplicateType('fire');
                    adjustScore();
                    userInfo.draw++;
                    info = 'Fire is even against Fire';
                    end = 'tied!';
                    break;
                
                case 'Grass':

                    RemoveButtons();
                    addLeftPic('fire');
                    addRightPic('grass');
                    adjustScore();
                    userInfo.userWin++;
                    info = 'Fire beats Grass';
                    end = 'won!';
                    break;
            }
        }  

        else if (userChoice == 'Grass') {

            switch (compChoice) {

                case 'Water':

                    RemoveButtons();
                    addLeftPic('grass');
                    addRightPic('water');
                    adjustScore();
                    userInfo.userWin++;
                    info = 'Grass beats Water';
                    end = 'won!';
                    break;
                
                case 'Fire':

                    RemoveButtons();
                    addLeftPic('fire');
                    addRightPic('grass');
                    adjustScore();
                    userInfo.userLoss++;
                    info = 'Grass is weak against Fire';
                    end = 'lost...';
                    break;

                case 'Grass':

                    RemoveButtons();
                    duplicateType('grass');
                    adjustScore();
                    userInfo.draw++;
                    info = 'Grass is even against Grass';
                    end = 'tied!';
                    break;
            }
        }  


        document.querySelector('.choice').innerHTML = info;
        document.querySelector('.result').innerHTML = 'You ' + end;
        document.querySelector('.score').innerHTML = 'Wins: ' + userInfo.userWin + ' | Losses: ' + userInfo.userLoss + ' | Draws: ' + userInfo.draw;
        document.querySelector('.percentage').innerHTML = 'Win Percentage: ' + Math.round((userInfo.userWin / (userInfo.userWin + userInfo.userLoss + userInfo.draw) * 100)) + '%';
        resetButtonInfo();

    }

    
    function adjustScore() {

        document.getElementById('div_score').style.marginLeft = '120px';
        document.getElementById('div_score').style.marginRight = '0px';
        document.getElementById('div_score').style.display = 'inline-block';
        
    }

    function reAdjustScore() {

        document.getElementById('div_score').style.marginLeft = '400px';
        document.getElementById('div_score').style.marginRight = 'auto';
        document.getElementById('div_score').style.display = 'inline-block';
        document.getElementById('div_score').style.width = '200px';
        document.getElementById('div_score').style.height = '150px';
        document.getElementById('div_score').style.maxWidth = '200px';
        document.getElementById('div_score').style.marginTop = '45px';
    }

    function addLeftPic(type) {

        switch (type) {

        case 'fire':
            document.getElementById('div_score').before(fire);
            adjustLeftPic(fire);
            break;

        case 'water':
            document.getElementById('div_score').before(water);
            adjustLeftPic(water);
            break;
        
        case 'grass':
            document.getElementById('div_score').before(grass);
            adjustLeftPic(grass);
            break;

        default:
            break;

        }
    }

    function addRightPic(type) {

        switch (type) {

        case 'fire':
            document.getElementById('div_score').after(fire);
            adjustRightPic(fire);
            break;

        case 'water':
            document.getElementById('div_score').after(water);
            adjustRightPic(water);
            break;

        case 'grass':
            document.getElementById('div_score').after(grass);
            adjustRightPic(grass);
            break;

        default:
            break;

        }

    }

    function duplicateType(type) {

        switch (type) {

            case 'fire':
                document.getElementById('div_score').before(fire);
                document.getElementById('div_score').after(fireCopy);
                adjustLeftPic(fire);
                adjustRightPic(fireCopy);
                break;
    
            case 'water':
                document.getElementById('div_score').before(water);
                document.getElementById('div_score').after(waterCopy);
                adjustLeftPic(water);
                adjustRightPic(waterCopy);
                break;
            
            case 'grass':
                document.getElementById('div_score').before(grass);
                document.getElementById('div_score').after(grassCopy);
                adjustLeftPic(grass);
                adjustRightPic(grassCopy);
                break;
    
            default:
                break;
    
        }
    }

    
    function adjustRightPic(pic) {

        pic.style.width = '80px';
        pic.style.height = '80px';
        pic.style.marginRight = '45px';
        pic.style.marginLeft = '200px';
        pic.style.display = 'inline-block';

    }

    function adjustLeftPic(pic) {

        
        pic.style.width = '80px';
        pic.style.height = '80px';
        pic.style.marginRight = '100px';
        pic.style.marginLeft = '100px';
        pic.style.display = 'inline-block';
    }

    function getWins() {

        return userInfo.userWin;
    }

    function RemoveButtons() {

        fire.remove();
        water.remove();
        grass.remove();
        fireCopy.remove();
        waterCopy.remove();
        grassCopy.remove();


    }

    function reset() {

        userInfo.userWin = 0;
        userInfo.userLoss = 0;
        userInfo.draw = 0;

        info = '';
        end = '';

        document.querySelector('.score').innerHTML = 'Wins: ' + userInfo.userWin + ' | Losses: ' + userInfo.userLoss + ' | Draws: ' + userInfo.draw;
        document.querySelector('.choice').innerHTML = info;
        document.querySelector('.result').innerHTML = end;
        document.querySelector('.percentage').innerHTML = '';
        reset_button.remove();
        fire.remove();
        water.remove();
        grass.remove();
        fireCopy.remove();
        waterCopy.remove();
        grassCopy.remove();

        reAdjustScore();
    }

    function resetButtonInfo() {

        reset_button.style.marginTop = '40px';
        document.getElementById('grid-score').appendChild(reset_button);
        reset_button.innerText = 'Reset';
        reset_button.style.display = 'block';
        reset_button.style.marginLeft = '477px';
        reset_button.addEventListener('click', reset);
        reset_button.addEventListener('mousedown', resetButtonClick);
        reset_button.style.backgroundColor = 'red';
        reset_button.style.color = 'black';
        reset_button.style.borderStyle = 'solid';
        reset_button.style.fontWeight = 'bold';
        reset_button.style.width = '50px';
        reset_button.style.borderColor = 'black';
        reset_button.addEventListener('mouseover', resetButtonHover);
        reset_button.addEventListener('mouseleave', resetButtonLeave);

    }

    function resetButtonHover() {

        reset_button.style.cursor = 'pointer';
        reset_button.style.backgroundColor = 'white';
        reset_button.style.color = 'red';
        reset_button.style.fontWeight = 'bold';
    }

    function resetButtonLeave() {

        reset_button.style.backgroundColor = 'red';
        reset_button.style.color = 'black';

    }

    function resetButtonClick() {

        reset_button.style.backgroundColor = 'black';
        reset_button.style.color = 'red';

    }