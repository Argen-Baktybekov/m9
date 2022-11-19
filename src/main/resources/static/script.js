'use strict'
const  BASE_URL = "http://172.29.177.44:8081";

// const SEARCH_URL = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=";
// const INGREDIENT_URL = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?i=";
// const SEARCH_BY_ID_URL = "https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=";


const searchButton = document.getElementById('search-button');

searchButton.addEventListener('click', () => {
    const searchInput = document.getElementById('search-input');
    const inputValue = searchInput.value;
    getPage(inputValue,0)
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
        '<span  class="bookmark h2 mx-2 muted "><i class="bi bi-bookmark ms-auto"></i></span>' +
        '<h3> ' +post.name +':'+ post.price + '</h3>\n' +

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
function getPage (inputValue, page){
    axios.get(BASE_URL + "/item/searchItems?item="+inputValue+"&page="+page)
        .then(function (response) {
            let items = response.data;
            console.log(response.data);
            items.forEach(
                (item) => { addItem(item) });
        })
        .catch(function (error) {
            console.log('error from back: ' + error);
        });
}

