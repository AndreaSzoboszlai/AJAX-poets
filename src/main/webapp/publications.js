function onSearchedPoem() {
    const searchFormEl = document.forms['search-form'];
    const searchedEl = searchFormEl.querySelector('input[name="searched"]').value;

    const containerEl = document.getElementById('poems').textContent;
    const regexS = new RegExp(searchedEl, 'g');
    const count = (containerEl.match(regexS) || []).length;

    document.getElementById('counter').classList.remove('hidden');
    const counterEl = document.getElementById('counter');
    counterEl.textContent = 'Counted occurande of "' + searchedEl + '": ' + count;
}

function removePoem() {
    document.getElementById('main-head').textContent = 'Your poems';
    const containerEl = document.getElementById('poems');
    const counterEl = document.getElementById('counter');

    counterEl.textContent = '';
    counterEl.classList.add('hidden');
    document.getElementById("search-form").classList.add('hidden');
    document.getElementById("login-to-search").classList.remove('hidden');
    onLoginPoet();
}

function removePoemList() {
    const containerEl = document.getElementById('poems');
    while (containerEl.firstChild) {
        containerEl.removeChild(containerEl.firstChild);
    }
}

function onPoemLoad(poem) {
    document.getElementById('main-head').textContent = poem.title;
    removePoemList();
    const containerEl = document.getElementById('poems');
    containerEl.textContent = poem.content;
    var btn = document.createElement("BUTTON");
    btn.innerHTML = "Back to poems";
    containerEl.appendChild(btn);

    document.getElementById("search-form").classList.remove('hidden');
    document.getElementById("login-to-search").classList.add('hidden');

    const searchbtn = document.getElementById('search-button');
    searchbtn.addEventListener('click', onSearchedPoem);

    btn.setAttribute('id', 'back-button');
    btn.addEventListener('click', removePoem);
}

function onPoemResponse() {
    if (this.status === OK) {
        onPoemLoad(JSON.parse(this.responseText));
    } else {
        onOtherResponse(couponsContentDivEl, this);
    }
}

function onClickedPoem() {
    const poemId = this.dataset.poemId;

    const params = new URLSearchParams();
    params.append('id', poemId);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onPoemResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'protected/publication?' + params.toString());
    xhr.send();
}

function createPoetryTable(poems) {
    const ulCommentEl = document.createElement('ul');
    ulCommentEl.classList.add('poems');

    for (let i = 0; i < poems.length; i++) {
        const poem = poems[i];
        ulCommentEl.setAttribute('id', poem.pId);

        const strongCEl = document.createElement('strong');
        strongCEl.textContent = poem.title;

        const aEl = document.createElement('a');
        aEl.href = 'javascript:void(0);';
        aEl.dataset.poemId = poem.pId;
        aEl.appendChild(strongCEl);
        aEl.appendChild(document.createTextNode(`: ${poem.publishedYear}`));

        aEl.addEventListener('click', onClickedPoem);
        const liCEl = document.createElement('li');
        liCEl.appendChild(aEl);

        ulCommentEl.appendChild(liCEl);
    }
    return ulCommentEl;
}

function onLoadPoet(poems) {
    const containerEl = document.getElementById('poems');
    containerEl.appendChild(createPoetryTable(poems));
}

function onPoetResponse() {
    clearMessages();
    if (this.status === OK) {
        onLoadPoet(JSON.parse(this.responseText));
    } else {
        onOtherResponse(couponsContentDivEl, this);
    }
}

function onLoginPoet() {
    removePoemList();
    const loginFormEl = document.forms['login-form'];

    const nameInputEl = loginFormEl.querySelector('input[name="name"]');

    const name = nameInputEl.value;

    const params = new URLSearchParams();
    params.append('name', name);

    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onPoetResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('POST', 'protected/publications');
    xhr.send(params);
}

