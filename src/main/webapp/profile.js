function onShopsClicked() {
    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onShopsResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'protected/shops');
    xhr.send();
}

function onCouponsClicked() {
    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onCouponsResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', 'protected/coupons');
    xhr.send();
}

function onProfileLoad(user) {
    clearMessages();
    showContents(['profile-content']);

    const userNameSpandEl = document.getElementById('user-name');

    const userTitleEl = document.getElementById('login-title');

    userNameSpandEl.textContent = user.loginName;

    userTitleEl.textContent = "Profile";

    document.getElementById("login-form").classList.add('hidden');
    document.getElementById("showprofile-content").classList.remove('hidden')
    document.getElementById("logout-content").classList.remove('hidden')

}
