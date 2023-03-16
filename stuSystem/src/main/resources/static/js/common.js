//防非法进入登录
function forbidden(){ 
    if(typeof(localStorage.getItem('username')=='undefined')||localStorage.getItem('username')==''){
        alert('非法进入,请登录');
        location.href='../login.html';
    }
}