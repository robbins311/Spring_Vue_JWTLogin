function saveAuthToCookie(value) { // 토큰 값을 쿠키에 셋팅
    document.cookie = `til_auth=${value}`;
}

function saveUserToCookie(value) { // username 값을 쿠키에 싯팅
    document.cookie = `til_user=${value}`;
}

function getAuthFromCookie() { // 저장된 토큰값 가져오기
    return document.cookie.replace(
        /(?:(?:^|.*;\s*)til_auth\s*=\s*([^;]*).*$)|^.*$/,
        '$1',
    );
}

function getUserFromCookie() { // 저장된 유저값 가져오기
    return document.cookie.replace(
        /(?:(?:^|.*;\s*)til_user\s*=\s*([^;]*).*$)|^.*$/,
        '$1',
    );
}

function deleteCookie(value) {
    document.cookie = `${value}=; expires=Thu, 01 Jan 1970 00:00:01 GMT;`;
}

export {
    saveAuthToCookie,
    saveUserToCookie,
    getAuthFromCookie,
    getUserFromCookie,
    deleteCookie,
};