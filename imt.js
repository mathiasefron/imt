
var chars = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','_'];
var word = process.argv[2];
var found = false;
var attempt = "";

console.log("\nInfinite Monkey Theorem!");
console.log("------------------------");

while(word !== attempt){
	attempt = "";
	for(var i=0; i<word.length; i++){
		attempt = attempt + chars[random(0, chars.length)];
	}
}

console.log("found " + attempt + "\n");

function prettyTime(seconds){
	if(seconds < 1){
		return "less than a second";
	}else if(seconds == 1){
		return "one second";
	}else{
		return seconds + " seconds";
	}
}

function random(a, b){
	return  Math.floor((b-a) * Math.random() + a);
}

