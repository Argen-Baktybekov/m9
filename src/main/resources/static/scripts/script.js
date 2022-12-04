'use strict'
const  BASE_URL = "http://172.29.176.210:8081";
// const  BASE_URL = "http://192.168.33.128:8081";
// const  BASE_URL = "http://192.168.1.106:8081";

let PAGE = 0;
let SIZE = 3;
let INPUT_VALUE;

const searchButton = document.getElementById('search-button');

searchButton.addEventListener('click', () => {
    const searchInput = document.getElementById('search-input');
    INPUT_VALUE = searchInput.value;
    PAGE = 0;
    getPage(INPUT_VALUE)
});

const prevButton = document.getElementById('prev');
prevButton.addEventListener('click', () => {
    if (PAGE >0){
        PAGE--;
        getPage(INPUT_VALUE)
    }
});
const nextButton = document.getElementById('next');
nextButton.addEventListener('click', () => {
    PAGE++;
    getPage(INPUT_VALUE)
});

function createItem(post){
    document.createElement('div')
    const newPost = document.createElement('div');
    newPost.classList.add('card');
    newPost.classList.add('mt-1');
    newPost.id = 'post'+post.id;
    newPost.style = 'width: 18rem';
    newPost.innerHTML = '<img src= "' + post.image + '" class="card-img-top" alt="#">';

    const cardBody = document.createElement('div');
    cardBody.classList.add('card-body');
    newPost.append(cardBody);

    cardBody.innerHTML =

        '<h5> ' +'<span  class="bookmark h2 mx-2 muted text-end"><i class="bi bi-cart4 "></i></span>' + post.name +': '+ post.price +"$"+ '</h5>\n' +

        '<button type="submit"  class="btn btn-primary">Buy</button>';

    return newPost;
}
function addItem(item){
        const itemElement = createItem(item);
        // addLikeFunction(postElement);
        // addChatFunction(postElement);
        // addBookmarkFunction(postElement);
        document.getElementById("contents").prepend(itemElement);
}
function getPage (inputValue){

    axios.get(BASE_URL + "/item/searchItems?item="+inputValue+"&page="+PAGE+"&size="+SIZE)
        .then(function (response) {
            document.getElementById("contents").innerHTML="";
            let items = response.data;
            console.log(response.data);
            items.forEach(
                (item) => { addItem(item) });
      })
        .catch(function (error) {
            console.log('error from back: ' + error);
        });
}

