function createPoetryTable(poems) {
    const ulCommentEl = document.createElement('ul');
    ulCommentEl.classList.add('poems');

    for (let i = 0; i < poems.length; i++) {
        const poem = poems[i];
        ulCommentEl.setAttribute('id', poem.uId);

        const strongCEl = document.createElement('strong');
        strongCEl.textContent = poem.title;

        const pCEl = document.createElement('p');
        pCEl.appendChild(strongCEl);
        pCEl.appendChild(document.createTextNode(`: ${poem.publishedYear}`));

        const liCEl = document.createElement('li');
        liCEl.appendChild(pCEl);

        ulCommentEl.appendChild(liCEl);
    }
    return ulCommentEl;
}

function onLoadPoet(poems) {
    console.log('Things got here I have no idea what to do now');
    const containerEl = document.getElementById('poems');
    console.log(poems);
    const text = "Text try";
    containerEl.appendChild(createPoetryTable(poems));
}

function onPoetResponse() {
    console.log("Fuck");
    console.log(this.responseText);
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

