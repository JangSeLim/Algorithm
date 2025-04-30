const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = [line];
}).on('close',function(){
    str = input[0];
    
    function swapCase(str) {
        return str.split('').map(char => {
            return char === char.toUpperCase()
            ? char.toLowerCase()
            : char.toUpperCase();
        }).join('');
    }
    console.log(swapCase(input[0]));
});