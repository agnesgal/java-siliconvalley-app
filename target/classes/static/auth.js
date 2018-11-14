window.addEventListener('DOMContentLoaded', function() {

    var webAuth = new auth0.WebAuth({
        domain: 'svalley.auth0.com',
        clientID: '8j3Zhl1W7QvwSmRrhJ1799sX5wv8IAqr',
        responseType: 'token id_token',
        scope: 'openid profile email',
        redirectUri: window.location.href + 'index'
    });

    var loginBtn = document.getElementById('btn-login');

    loginBtn.addEventListener('click', function(e) {
        e.preventDefault();
        webAuth.authorize();
    });

    var loginStatus = document.querySelector('.container h4');
    var loginView = document.getElementById('login-view');
    var homeView = document.getElementById('home-view');

    // buttons and event listeners
    var homeViewBtn = document.getElementById('btn-home-view');
    var loginBtn = document.getElementById('btn-login');
    var logoutBtn = document.getElementById('btn-logout');

    homeViewBtn.addEventListener('click', function() {
        homeView.style.display = 'inline-block';
        loginView.style.display = 'none';
    });

    logoutBtn.addEventListener('click', logout);

    function handleAuthentication() {
        webAuth.parseHash(function(err, authResult) {
            if (authResult && authResult.accessToken && authResult.idToken) {
                window.location.hash = '';
                setSession(authResult);
                webAuth.client.userInfo(authResult.accessToken, function(err, profile) {
                    debugger;
                    if (profile) {
                        userProfile = profile;
                        displayProfile();
                    }
                });
                loginBtn.style.display = 'none';
                homeView.style.display = 'inline-block';
            } else if (err) {
                homeView.style.display = 'inline-block';
                console.log(err);
                alert(
                    'Error: ' + err.error + '. Check the console for further details.'
                );
            }
            displayButtons();
        });
    }

    function setSession(authResult) {
        // Set the time that the Access Token will expire at
        var expiresAt = JSON.stringify(
            authResult.expiresIn * 1000 + new Date().getTime()
        );
        localStorage.setItem('access_token', authResult.accessToken);
        localStorage.setItem('id_token', authResult.idToken);
        localStorage.setItem('expires_at', expiresAt);
    }

    var tokenRenewalTimeout;

    function scheduleRenewal() {
        var expiresAt = JSON.parse(localStorage.getItem('expires_at'));
        var delay = expiresAt - Date.now();
        if (delay > 0) {
            tokenRenewalTimeout = setTimeout(function() {
                renewToken();
            }, delay);
        }
    }


    function logout() {
        // Remove tokens and expiry time from localStorage
        localStorage.removeItem('access_token');
        localStorage.removeItem('id_token');
        localStorage.removeItem('expires_at');
        displayButtons();
        clearTimeout(tokenRenewalTimeout);
        window.location = "https://svalley.auth0.com/v2/logout";
    }

    function isAuthenticated() {
        // Check whether the current time is past the
        // Access Token's expiry time
        var expiresAt = JSON.parse(localStorage.getItem('expires_at'));
        return new Date().getTime() < expiresAt;
    }

    function displayButtons() {
        if (isAuthenticated()) {
            loginBtn.style.display = 'none';
            logoutBtn.style.display = 'inline-block';
            loginStatus.innerHTML = 'You are logged in!';
        } else {
            loginBtn.style.display = 'inline-block';
            logoutBtn.style.display = 'none';
            loginStatus.innerHTML =
                'You are not logged in! Please log in to continue.';
        }
    }

    function userHasScopes(scopes) {
        var savedScopes = JSON.parse(localStorage.getItem('scopes'));
        if (!savedScopes) return false;
        var grantedScopes = savedScopes.split(' ');
        for (var i = 0; i < scopes.length; i++) {
            if (grantedScopes.indexOf(scopes[i]) < 0) {
                return false;
            }
        }
        return true;
    }

    function displayProfile() {
        // display the profile
        document.querySelector('#profile-view .nickname').innerHTML =
            userProfile.nickname;

        document.querySelector(
            '#profile-view .full-profile'
        ).innerHTML = JSON.stringify(userProfile, null, 2);

        document.querySelector('#profile-view img').src = userProfile.picture;
    }

    function renewToken() {
        webAuth.checkSession({},
            function(err, result) {
                if (err) {
                    console.log(err);
                } else {
                    setSession(result);
                }
            }
        );
    }

    handleAuthentication();
    scheduleRenewal();

});