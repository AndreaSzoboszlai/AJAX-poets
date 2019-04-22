function removePoem() {
    const containerEl = document.getElementById('poems');
    containerEl.textContent = '';
    onLoginPoet();
}


function onPoemLoad(poem) {
    const containerEl = document.getElementById('poems');
    while (containerEl.firstChild) {
        containerEl.removeChild(containerEl.firstChild);
    }
    containerEl.textContent = poem.content;
    var btn = document.createElement("BUTTON");
    btn.innerHTML = "Back to poems";
    containerEl.appendChild(btn);
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
    console.log(poemId);
    const params = new URLSearchParams();
    params.append('id', poemId);
    console.log(params);
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

