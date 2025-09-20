4

const moveBy = 10;
const x = 0;
const y = 0;


    document.addEventListener("keydown", event =>

    {
        
        switch (event.key) {
            case "ArrowUp":
                y -= moveBy;
                break;
            case "ArrowDown":
                y += moveBy;
                break;
            case "ArrowLeft":
                x -= moveBy;
                break;
            case "ArrowRight":
                x += moveBy;
                break;
        }

        document.getElementById("snake").style.top = '${x}px';
        document.getElementById("snake").style.backgroundColor = "green";
    });

    document.addEventListener("keyup", event =>

        {
            
            document.getElementById("snake").style.backgroundColor = "red";
            console.log(event.key);
        }
    );
