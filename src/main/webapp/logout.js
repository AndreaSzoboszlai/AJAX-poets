function onLogoutResponse() {
    if (this.status === OK) {
        setUnauthorized();
        clearMessages();
        changeProfileLook();
    } else {
        onOtherResponse(logoutContentDivEl, this);
    }
}

function onLogoutButtonClicked(event) {
    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onLogoutResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('POST', 'protected/logout');
    xhr.send();
}

function changeProfileLook() {
    const userTitleEl = document.getElementById('login-title');
    userTitleEl.textContent = "Login";
    document.getElementById("profile-content").classList.add('hidden');
    document.getElementById("login-form").classList.remove('hidden');
    document.getElementById("showprofile-content").classList.add('hidden');
    document.getElementById("logout-content").classList.add('hidden');
}
