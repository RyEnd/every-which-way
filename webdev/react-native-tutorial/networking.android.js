fetch('https://mywebsite.com/endpoint/', {
  method: 'POST',
  headers: {
  	'Accept': 'application/json',
  	'Content-Type': 'application/json',
  },
  body: JSON.stringify({
  	firstParam: 'yourValue',
  	secondParam: 'yourOtherValue',
  })
})

/**
 *
 */

function getMoviesFromApiAsync() {
  return fetch('https://facebook.github.io/react-native/movies.json')
    .then((response) => response.json())
    .then((responseJson) => {
      return responseJson.movies;
    })
    .catch((error) => {
      console.error(error);
    });
}

/**
 *ES7 async protocol
 */

async function getMoviesFromApi() {
  try {
  	let response = await fetch('https://facebook.github.io/react-native/movies.json');
  	let responseJson = await response.json();
  	return responseJson.movies;
  } catch(error) {
  	console.error(error);
  }
}

/**
 *XMLHttpRequest API
 */

var request = new XMLHttpRequest();
request.onreadystatechange = (e) => {
  if (request.readyState !== 4) {
  	return;
  }

  if (request.status === 200) {
  	console.log('success', request.responseText);
  } else {
  	console.warn('error');
  }
};

request.open('GET', 'https://mywebsite.com/endpoint/');
request.send();

/**
 *websockets
 */

var ws = new WebSocket('ws://host.com/path');

ws.onopen = () => {
  //connection opened
  ws.send('something'); //send message
};

ws.onmessage = (e) => {
  //a message was received
  console.log(e.date);
};

ws.onerror = (e) => {
  //an error occurred
  console.log(e.message);
};

ws.onclose = (e) => {
  //connection closed
  console.log(e.code, e.reason);
};